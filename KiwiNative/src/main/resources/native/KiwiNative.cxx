/*=========================================================================

  Program:   Visualization Toolkit

  Copyright (c) Ken Martin, Will Schroeder, Bill Lorensen
  All rights reserved.
  See Copyright.txt or http://www.kitware.com/Copyright.htm for details.

     This software is distributed WITHOUT ANY WARRANTY; without even
     the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR
     PURPOSE.  See the above copyright notice for more information.

=========================================================================*/
/*
 * Copyright (C) 2010 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

#define vtkRenderingCore_AUTOINIT 3(vtkInteractionStyle,vtkRenderingFreeType,/*vtkRenderingFreeTypeOpenGL,*/vtkRenderingOpenGL2)
//#define vtkRenderingVolume_AUTOINIT 1(vtkRenderingVolumeOpenGL)

#include <jni.h>
#include <errno.h>
#include <sstream>
#include <sys/stat.h>
#include <string.h> //added by subhadeep


#include "vtkNew.h"

#include "vtkActor.h"
#include "vtkCamera.h"
#include "vtkConeSource.h"
#include "vtkDebugLeaks.h"
#include "vtkGlyph3D.h"
#include "vtkPolyData.h"
#include "vtkPolyDataMapper.h"
#include "vtkRenderWindow.h"
#include "vtkRenderer.h"
#include "vtkSphereSource.h"
#include "vtkTextActor.h"
#include "vtkTextProperty.h"
#include "vtkPolyDataReader.h"
#include "vtkRendererCollection.h"

#include "vtkAndroidRenderWindowInteractor.h"
#include "vtkCommand.h"

#include <android/log.h>


//20180320
#include "vtkSTLReader.h"
#include "vtkPolyDataNormals.h"


//20180712
#include "vtkOBJReader.h"

#include "vtkProperty.h"  //added by subhadeep


#define LOGI(...) ((void)__android_log_print(ANDROID_LOG_INFO, "NativeVTK", __VA_ARGS__))
#define LOGW(...) ((void)__android_log_print(ANDROID_LOG_WARN, "NativeVTK", __VA_ARGS__))

extern "C" {

    JNIEXPORT void JNICALL Java_com_kitware_KiwiApp_Viewer_KiwiNativeVtk_resize(JNIEnv * env, jobject obj, jlong udp, jint width, jint height);
    JNIEXPORT void JNICALL Java_com_kitware_KiwiApp_Viewer_KiwiNativeVtk_setCameraPosition(JNIEnv * env, jobject obj, jlong udp, jdouble x, jdouble y, jdouble z);
    JNIEXPORT void JNICALL Java_com_kitware_KiwiApp_Viewer_KiwiNativeVtk_setCameraViewUp(JNIEnv * env, jobject obj, jlong udp, jdouble x, jdouble y, jdouble z);
    JNIEXPORT void JNICALL Java_com_kitware_KiwiApp_Viewer_KiwiNativeVtk_setCameraFocalPoint(JNIEnv * env, jobject obj, jlong udp, jdouble x, jdouble y, jdouble z);
    JNIEXPORT void JNICALL Java_com_kitware_KiwiApp_Viewer_KiwiNativeVtk_setBackground(JNIEnv * env, jobject obj, jlong udp, jdouble r, jdouble g, jdouble b);

    JNIEXPORT void JNICALL Java_com_kitware_KiwiApp_Viewer_KiwiNativeVtk_loaddataset(JNIEnv * env, jobject obj, jlong udp, jstring file);

    JNIEXPORT void JNICALL Java_com_kitware_KiwiApp_Viewer_KiwiNativeVtk_loaddatasetcol(JNIEnv * env, jobject obj, jlong udp, jstring file, jdouble r, jdouble g, jdouble b);

    JNIEXPORT void JNICALL Java_com_kitware_KiwiApp_Viewer_KiwiNativeVtk_loaddatasetstl(JNIEnv * env, jobject obj, jlong udp, jstring file);
    JNIEXPORT void JNICALL Java_com_kitware_KiwiApp_Viewer_KiwiNativeVtk_loaddatasetobj(JNIEnv * env, jobject obj, jlong udp, jstring file);
    JNIEXPORT void JNICALL Java_com_kitware_KiwiApp_Viewer_KiwiNativeVtk_rotateCameraAzimuth(JNIEnv * env, jobject obj, jlong udp, jdouble angle);

    JNIEXPORT void JNICALL Java_com_kitware_KiwiApp_Viewer_KiwiNativeVtk_onKeyEvent(JNIEnv * env, jobject obj, jlong udp,
      jboolean down, jint keyCode, jint metaState, jint repeatCount);
    JNIEXPORT void JNICALL Java_com_kitware_KiwiApp_Viewer_KiwiNativeVtk_onMotionEvent(JNIEnv * env, jobject obj, jlong udp,
      jint action,
      jint eventPointer,
      jint numPtrs,
      jfloatArray xPos, jfloatArray yPos,
      jintArray ids, jint metaState);

    //the functions below have been modified by subhadeep
    JNIEXPORT jlong JNICALL Java_com_kitware_KiwiApp_Viewer_KiwiNativeVtk_init(JNIEnv * env, jobject obj,  jint width, jint height, jdouble r, jdouble g, jdouble b);
    JNIEXPORT void JNICALL Java_com_kitware_KiwiApp_Viewer_KiwiNativeVtk_render(JNIEnv * env, jobject obj, jlong renWinP);
    JNIEXPORT void JNICALL Java_com_kitware_KiwiApp_Viewer_KiwiNativeVtk_resetCamera(JNIEnv * env, jobject obj, jlong udp);

    JNIEXPORT jdoubleArray JNICALL Java_com_kitware_KiwiApp_Viewer_KiwiNativeVtk_getCameraViewUp(JNIEnv * env, jobject obj, jlong udp);
    JNIEXPORT jdoubleArray JNICALL Java_com_kitware_KiwiApp_Viewer_KiwiNativeVtk_getCameraPosition(JNIEnv * env, jobject obj, jlong udp);
    JNIEXPORT jdoubleArray JNICALL Java_com_kitware_KiwiApp_Viewer_KiwiNativeVtk_getCameraFocalPoint(JNIEnv * env, jobject obj, jlong udp);

    JNIEXPORT jdouble JNICALL Java_com_kitware_KiwiApp_Viewer_KiwiNativeVtk_getCameraRoll(JNIEnv * env, jobject obj, jlong udp);
    JNIEXPORT void JNICALL Java_com_kitware_KiwiApp_Viewer_KiwiNativeVtk_setCameraRoll(JNIEnv * env, jobject obj, jlong udp, jdouble angle);

    JNIEXPORT void JNICALL Java_com_kitware_KiwiApp_Viewer_KiwiNativeVtk_loadMultipleModels(JNIEnv * env, jobject obj, jlong udp, jobjectArray files, jobjectArray rgb, jdoubleArray opacity, jobjectArray position);

};




struct userData
{
  vtkRenderWindow *RenderWindow;
  vtkRenderer *Renderer;
  vtkAndroidRenderWindowInteractor *Interactor;
};




JNIEXPORT jlong JNICALL Java_com_kitware_KiwiApp_Viewer_KiwiNativeVtk_init(JNIEnv * env, jobject obj,  jint width, jint height, jdouble r, jdouble g, jdouble b)
{
  vtkRenderWindow *renWin = vtkRenderWindow::New();
  char jniS[4] = {'j','n','i',0};
  renWin->SetWindowInfo(jniS); // tell the system that jni owns the window not us
  renWin->SetSize(width,height);

  vtkNew<vtkRenderer> renderer;
  renWin->AddRenderer(renderer.Get());

  vtkNew<vtkAndroidRenderWindowInteractor> iren;
  iren->SetRenderWindow(renWin);

  renderer->SetBackground(r,g,b);

  struct userData *foo = new struct userData();
  foo->RenderWindow = renWin;
  foo->Renderer = renderer.Get();
  foo->Interactor = iren.Get();

  return (jlong)foo;
}



JNIEXPORT void JNICALL Java_com_kitware_KiwiApp_Viewer_KiwiNativeVtk_resize(JNIEnv * env, jobject obj, jlong udp, jint width, jint height)
{
    struct userData *foo = (userData *)(udp);
    foo->RenderWindow->SetSize(width,height);
}



JNIEXPORT void JNICALL Java_com_kitware_KiwiApp_Viewer_KiwiNativeVtk_render(JNIEnv * env, jobject obj, jlong udp)
{
  struct userData *foo = (userData *)(udp);
  foo->RenderWindow->Render();
  foo->RenderWindow->SwapBuffersOn();
}




 JNIEXPORT void JNICALL Java_com_kitware_KiwiApp_Viewer_KiwiNativeVtk_loaddataset(JNIEnv * env, jobject obj, jlong udp, jstring file)
 {
    struct userData *foo = (userData *)(udp);

    vtkNew<vtkPolyDataReader> reader;
    const char* file_c = env->GetStringUTFChars(file, NULL);

    struct stat st;
    stat(file_c, &st);
    int size = st.st_size;
    //reader->ReadFromInputStringOn();

    reader->SetFileName(file_c);
    //reader->SetBinaryInputString(file_c, size);
    reader->Update();

    //LOGI("%d %s", reader->GetOutput()->GetNumberOfPoints(), file_c);

    vtkNew<vtkPolyDataMapper> mapper;
    mapper->SetInputData(reader->GetOutput());

    vtkNew<vtkActor> actor;
    actor->SetMapper(mapper.GetPointer());

    foo->Renderer->AddActor(actor.GetPointer());
    foo->Renderer->ResetCamera();

    env->ReleaseStringUTFChars(file, file_c);
 }

 JNIEXPORT void JNICALL Java_com_kitware_KiwiApp_Viewer_KiwiNativeVtk_loaddatasetcol(JNIEnv * env, jobject obj, jlong udp, jstring file, jdouble r, jdouble g, double b)
  {
     struct userData *foo = (userData *)(udp);

     vtkNew<vtkPolyDataReader> reader;
     const char* file_c = env->GetStringUTFChars(file, NULL);

     struct stat st;
     stat(file_c, &st);
     int size = st.st_size;
     //reader->ReadFromInputStringOn();

     reader->SetFileName(file_c);
     //reader->SetBinaryInputString(file_c, size);
     reader->Update();

     //LOGI("%d %s", reader->GetOutput()->GetNumberOfPoints(), file_c);

     vtkNew<vtkPolyDataMapper> mapper;
     mapper->SetInputData(reader->GetOutput());

     vtkNew<vtkActor> actor;
     actor->SetMapper(mapper.GetPointer());
     //set color of the actor
     actor->GetProperty()->SetColor(r, g, b); //(R,G,B)

     foo->Renderer->AddActor(actor.GetPointer());
     foo->Renderer->ResetCamera();

     env->ReleaseStringUTFChars(file, file_c);
  }


JNIEXPORT void JNICALL Java_com_kitware_KiwiApp_Viewer_KiwiNativeVtk_loaddatasetstl(JNIEnv * env, jobject obj, jlong udp, jstring file)
 {
    struct userData *foo = (userData *)(udp);

    //vtkNew<vtkPolyDataReader> reader;
    //vtkSmartPointer<vtkSTLReader> reader = vtkSmartPointer<vtkSTLReader>::New();
    vtkNew<vtkSTLReader> reader;
    const char* file_c = env->GetStringUTFChars(file, NULL);

    struct stat st;
    stat(file_c, &st);
    int size = st.st_size;

    reader->SetFileName(file_c);
    reader->Update();

    vtkNew<vtkPolyDataMapper> mapper;

    //mapper->SetInputData(reader->GetOutput());
    //BEGIN Edu
    vtkSmartPointer<vtkPolyDataNormals> normalGenerator = vtkSmartPointer<vtkPolyDataNormals>::New();
    normalGenerator->SetInputData(reader->GetOutput());
    normalGenerator->ComputePointNormalsOn();
    normalGenerator->ComputeCellNormalsOff();
    normalGenerator->Update();
    mapper->SetInputData(normalGenerator->GetOutput());
    //END Edu

    vtkNew<vtkActor> actor;
    actor->SetMapper(mapper.GetPointer());
    foo->Renderer->AddActor(actor.GetPointer());
    foo->Renderer->ResetCamera();
    env->ReleaseStringUTFChars(file, file_c);
 }


JNIEXPORT void JNICALL Java_com_kitware_KiwiApp_Viewer_KiwiNativeVtk_loaddatasetobj(JNIEnv * env, jobject obj, jlong udp, jstring file)
{
    struct userData *foo = (userData *)(udp);

    /*
    vtkNew<vtkPolyDataReader> reader;
    */

    /*
    //vtkSmartPointer<vtkSTLReader> reader = vtkSmartPointer<vtkSTLReader>::New();
    vtkNew<vtkSTLReader> reader;
    */

    //vtkSmartPointer<vtkOBJReader> reader = vtkSmartPointer<vtkOBJReader>::New();
    vtkNew<vtkOBJReader> reader;
    const char* file_c = env->GetStringUTFChars(file, NULL);

    struct stat st;
    stat(file_c, &st);
    int size = st.st_size;

    reader->SetFileName(file_c);
    reader->Update();

    vtkNew<vtkPolyDataMapper> mapper;
    //¿ mapper->setInputConnection(reader->GetOutputPort()); ?

    //mapper->SetInputData(reader->GetOutput());
    //BEGIN Edu
    vtkSmartPointer<vtkPolyDataNormals> normalGenerator = vtkSmartPointer<vtkPolyDataNormals>::New();
    normalGenerator->SetInputData(reader->GetOutput());
    normalGenerator->ComputePointNormalsOn();
    normalGenerator->ComputeCellNormalsOff();
    normalGenerator->Update();
    mapper->SetInputData(normalGenerator->GetOutput());
    //END Edu

    vtkNew<vtkActor> actor;
    actor->SetMapper(mapper.GetPointer());
    foo->Renderer->AddActor(actor.GetPointer());
    foo->Renderer->ResetCamera();
    //EDU foo->Renderer->ResetCameraClippingRange();
    env->ReleaseStringUTFChars(file, file_c);
}




JNIEXPORT void JNICALL Java_com_kitware_KiwiApp_Viewer_KiwiNativeVtk_resetCamera(JNIEnv * env, jobject obj, jlong udp)
{
    struct userData *foo = (userData *)(udp);
    foo->Renderer->ResetCamera();
}




/*
 * Here is where you would setup your pipeline and other normal VTK logic
 */
 JNIEXPORT void JNICALL Java_com_kitware_KiwiApp_Viewer_KiwiNativeVtk_setCameraPosition(JNIEnv * env, jobject obj, jlong udp, jdouble x, jdouble y, jdouble z)
 {
    struct userData *foo = (userData *)(udp);
    foo->Renderer->GetActiveCamera()->SetPosition(x, y, z);
 }

 JNIEXPORT void JNICALL Java_com_kitware_KiwiApp_Viewer_KiwiNativeVtk_setCameraViewUp(JNIEnv * env, jobject obj, jlong udp, jdouble x, jdouble y, jdouble z)
 {
    struct userData *foo = (userData *)(udp);
    foo->Renderer->GetActiveCamera()->SetViewUp(x, y, z);
 }

JNIEXPORT void JNICALL Java_com_kitware_KiwiApp_Viewer_KiwiNativeVtk_setCameraFocalPoint(JNIEnv * env, jobject obj, jlong udp, jdouble x, jdouble y, jdouble z)
{
    struct userData *foo = (userData *)(udp);
    foo->Renderer->GetActiveCamera()->SetFocalPoint(x, y, z);
}




/*
 * Returns the x, y and z coordinates of the camera as double array.
 * Where result[0] is x, result[1] is y, and result[2] is z.
 */

JNIEXPORT jdoubleArray JNICALL Java_com_kitware_KiwiApp_Viewer_KiwiNativeVtk_getCameraPosition(JNIEnv * env, jobject obj, jlong udp)
{
    jint resultLength = 3;
    jdoubleArray result = env->NewDoubleArray(resultLength);
    jdouble fill[resultLength];
    struct userData *foo = (userData *)(udp);
    foo->Renderer->GetActiveCamera()->GetPosition(fill);
    env->SetDoubleArrayRegion(result, 0, resultLength, fill);
    return result;
}



/*
 * Returns the x, y and z coordinates of the camera's view up as double array.
 * Where result[0] is x, result[1] is y, and result[2] is z.
 */

JNIEXPORT jdoubleArray JNICALL Java_com_kitware_KiwiApp_Viewer_KiwiNativeVtk_getCameraViewUp(JNIEnv * env, jobject obj, jlong udp)
{
    jint resultLength = 3;
    jdoubleArray result = env->NewDoubleArray(resultLength);
    jdouble fill[resultLength];
    struct userData *foo = (userData *)(udp);
    foo->Renderer->GetActiveCamera()->GetViewUp(fill);
    env->SetDoubleArrayRegion(result, 0, resultLength, fill);
    return result;
}



/*
 * Returns the x, y and z coordinates of the focal point of the camera as double array.
 * Where result[0] is x, result[1] is y, and result[2] is z.
 */

JNIEXPORT jdoubleArray JNICALL Java_com_kitware_KiwiApp_Viewer_KiwiNativeVtk_getCameraFocalPoint(JNIEnv * env, jobject obj, jlong udp)
{
    jint resultLength = 3;
    jdoubleArray result = env->NewDoubleArray(resultLength);
    jdouble fill[resultLength];
    struct userData *foo = (userData *)(udp);
    foo->Renderer->GetActiveCamera()->GetFocalPoint(fill);
    env->SetDoubleArrayRegion(result, 0, resultLength, fill);
    return result;
}




 JNIEXPORT void JNICALL Java_com_kitware_KiwiApp_Viewer_KiwiNativeVtk_setBackground(JNIEnv * env, jobject obj, jlong udp, jdouble r, jdouble g, jdouble b)
 {
    struct userData *foo = (userData *)(udp);
    foo->Renderer->SetBackground(r, g, b);
 }


 JNIEXPORT void JNICALL Java_com_kitware_KiwiApp_Viewer_KiwiNativeVtk_rotateCameraAzimuth(JNIEnv * env, jobject obj, jlong udp, jdouble angle)
  {
     struct userData *foo = (userData *)(udp);
     foo->Renderer->GetActiveCamera()->Azimuth(angle);
     foo->Renderer->ResetCameraClippingRange();
  }



 JNIEXPORT jdouble JNICALL Java_com_kitware_KiwiApp_Viewer_KiwiNativeVtk_getCameraRoll(JNIEnv * env, jobject obj, jlong udp)
  {
     struct userData *foo = (userData *)(udp);
     jdouble result = foo->Renderer->GetActiveCamera()->GetRoll();
     return result;
  }


 JNIEXPORT void JNICALL Java_com_kitware_KiwiApp_Viewer_KiwiNativeVtk_setCameraRoll(JNIEnv * env, jobject obj, jlong udp, jdouble angle)
  {
     struct userData *foo = (userData *)(udp);
     foo->Renderer->GetActiveCamera()->SetRoll(angle);
  }



JNIEXPORT void JNICALL Java_com_kitware_KiwiApp_Viewer_KiwiNativeVtk_onKeyEvent(JNIEnv * env, jobject obj, jlong udp,
  jboolean down, jint keyCode, jint metaState, jint repeatCount)
{
  struct userData *foo = (userData *)(udp);
  foo->Interactor->HandleKeyEvent(down, keyCode, metaState, repeatCount);
}


JNIEXPORT void JNICALL Java_com_kitware_KiwiApp_Viewer_KiwiNativeVtk_onMotionEvent(JNIEnv * env, jobject obj, jlong udp,
      jint action,
      jint eventPointer,
      jint numPtrs,
      jfloatArray xPos, jfloatArray yPos,
      jintArray ids, jint metaState)
{
  struct userData *foo = (userData *)(udp);

  int xPtr[VTKI_MAX_POINTERS];
  int yPtr[VTKI_MAX_POINTERS];
  int idPtr[VTKI_MAX_POINTERS];

  // only allow VTKI_MAX_POINTERS touches right now
  if (numPtrs > VTKI_MAX_POINTERS)
    {
    numPtrs = VTKI_MAX_POINTERS;
    }

  // fill in the arrays
  jfloat *xJPtr = env->GetFloatArrayElements(xPos, 0);
  jfloat *yJPtr = env->GetFloatArrayElements(yPos, 0);
  jint *idJPtr = env->GetIntArrayElements(ids, 0);
  int indice = 0;
  for (indice = 0; indice < numPtrs; ++indice)
    {
    xPtr[indice] = (int)xJPtr[indice];
    yPtr[indice] = (int)yJPtr[indice];
    idPtr[indice] = idJPtr[indice];
    }
  env->ReleaseIntArrayElements(ids, idJPtr, 0);
  env->ReleaseFloatArrayElements(xPos, xJPtr, 0);
  env->ReleaseFloatArrayElements(yPos, yJPtr, 0);

  foo->Interactor->HandleMotionEvent(action, eventPointer, numPtrs, xPtr, yPtr, idPtr, metaState);
}



/*
Coded by Subhadeep Patra

Trying to create a generic function that loads different files with different extensions (vtk, obj, stl) in the same screen.
This function can also be used to load a single file onscreen.
User can specify color, opacity and position of individual objects.

Data passed from Java/Android looks like the following:
long udp, String files[], double rgb[][], double opacity[], double position[][]

window, file1, r1 g1 b1, o1, x1 y1 z1;
        file2, r2 g2 b2, o2, x2 y2 z2;
*/
JNIEXPORT void JNICALL Java_com_kitware_KiwiApp_Viewer_KiwiNativeVtk_loadMultipleModels(JNIEnv * env, jobject obj, jlong udp, jobjectArray files, jobjectArray rgb, jdoubleArray opacity, jobjectArray position)
{
    jsize stringCount = env->GetArrayLength(files);
    if(stringCount > 0){

        struct userData *foo = (userData *)(udp);

        //get all the files names passed to this function
        const char *files_names[stringCount];   //this is where store the file names with locations
        for (int i=0; i<stringCount; i++) {
            jstring string = (jstring) env->GetObjectArrayElement(files, i);
            files_names[i] = env->GetStringUTFChars(string, NULL);
        }

        for (int i=0; i<stringCount; i++) {
            vtkNew<vtkPolyDataMapper> mapper;
            vtkNew<vtkActor> actor;
            if(strcasecmp(files_names[i] + strlen(files_names[i]) - 4, ".vtk") == 0) {
                //the files is vtk
                vtkNew<vtkPolyDataReader> reader;
                reader->SetFileName(files_names[i]);
                reader->Update();
                mapper->SetInputData(reader->GetOutput());
            }
            else {
                //the file is obj or stl
                vtkSmartPointer<vtkPolyDataNormals> normalGenerator = vtkSmartPointer<vtkPolyDataNormals>::New();
                if(strcasecmp(files_names[i] + strlen(files_names[i]) - 4, ".stl") == 0){
                    //file is stl
                    vtkNew<vtkSTLReader> reader;
                    reader->SetFileName(files_names[i]);
                    reader->Update();
                    normalGenerator->SetInputData(reader->GetOutput());
                }
                else if(strcasecmp(files_names[i] + strlen(files_names[i]) - 4, ".obj") == 0){
                    //file is obj
                    vtkNew<vtkOBJReader> reader;
                    reader->SetFileName(files_names[i]);
                    reader->Update();
                    normalGenerator->SetInputData(reader->GetOutput());
                }
                else {
                    //unknown file type
                }
                //common code for both file types
                normalGenerator->ComputePointNormalsOn();
                normalGenerator->ComputeCellNormalsOff();
                normalGenerator->Update();
                mapper->SetInputData(normalGenerator->GetOutput());

            }

            actor->SetMapper(mapper.GetPointer());

            jdoubleArray local_rgb = (jdoubleArray) env->GetObjectArrayElement(rgb, i);
            double* local_rgb_c  = env->GetDoubleArrayElements(local_rgb,0);
            actor->GetProperty()->SetColor(local_rgb_c[0], local_rgb_c[1], local_rgb_c[2]); //(R,G,B)

            jdouble *opacityOfModel = env->GetDoubleArrayElements(opacity, NULL);
            actor->GetProperty()->SetOpacity(opacityOfModel[i]);

            jdoubleArray local_position = (jdoubleArray) env->GetObjectArrayElement(position, i);
            double* local_position_c  = env->GetDoubleArrayElements(local_position,0);
            actor->SetPosition(local_position_c[0], local_position_c[1], local_position_c[2]); //position x,y,z

            foo->Renderer->AddActor(actor.GetPointer());
        }
        foo->Renderer->ResetCamera();
    }
}
