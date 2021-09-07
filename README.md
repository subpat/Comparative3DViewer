# Comparative3DViewer


A 3D model viewer for ANDROID that allows viewing one or multiple 3D objects on the same screen, depending on the chosen option at the "Number of models" spinner item. The application has been implemented in JAVA, follows the MVVM architectural guidelines.

Users can interract with the 3D models by zooming in or out, and rotating the models around. Note that the application supports screen rotations. It also restores the 3D objects as they were being viewed by the user in case the application was forced to the background and brought back to the foreground again, this is achieved by temporarily storing the camera parameters.

When viewing multiple models on screen, please use the "mode of operation" to select if the models are to be viewed on the same or seperate windows.

If two models are viewed on the same screen, it would make sense to choose the appropriate colors and transparancy for each of them.

When two 3D models are being viewed in seperate windows, their movements can be synchronized or unsychronized, causing the same movements for both the models when the user interracts with just one of them. This is useful when conducting a comparative study of two similar 3D models, imagine studying the recovery of a patient after surgery. Note that synchronized movement of the models can be toggled by a long press on screen.

Enjoy!




# Compilation

1. The project uses buildToolsVersion "28.0.3", please do not update it.

2. You will need Ndk-r16b for compiling and running this project, since part of the project is coded in C/C++. Please get it from: https://developer.android.com/ndk/downloads/older_releases

3. If you get the following erros:

ABIs [armeabi, mips] are not supported for platform. Supported ABIs are [arm64-v8a, armeabi-v7a, x86, x86_64].


OR 

com.android.builder.errors.EvalIssueException: ABIs [armeabi, mips] are not supported for platform. Supported ABIs are [arm64-v8a, armeabi-v7a, x86, x86_64].

This means the NDK (r16b) path is not available in the file: local.properties. Please add it, example: ndk.dir=C\:\\Users\\Subhadeep\\AppData\\Local\\Android\\Ndk-r16b


# Application Binary

Get the APK from https://github.com/subpat/Comparative3DViewer/releases/tag/Release_1.0.0


# Application Use

Use case 1: Viewing a single 3D model on screen.

Use case 2: Viewing two 3D models overlapped over each other for comparison purposes.

Use case 3: Viewing two 3D models side by side for comparison purposes.
