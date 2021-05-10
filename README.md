# Comparative3DViewer


A 3D model viewer for ANDROID that allows viewing one or multiple 3D objects on the same screen.

The application has been implemented in JAVA, follows the MVVM architectural guidelines.




NOTE:

1. The project uses buildToolsVersion "28.0.3", please do not update it.

2. You will need Ndk-r16b for compiling and running this project, since part of the project is coded in C/C++. Please get it from: https://developer.android.com/ndk/downloads/older_releases

3. If you get the following erros:

ABIs [armeabi, mips] are not supported for platform. Supported ABIs are [arm64-v8a, armeabi-v7a, x86, x86_64].


OR 

com.android.builder.errors.EvalIssueException: ABIs [armeabi, mips] are not supported for platform. Supported ABIs are [arm64-v8a, armeabi-v7a, x86, x86_64].

This means the NDK (r16b) path is not available in the file: local.properties. Please add it, example: ndk.dir=C\:\\Users\\Subhadeep\\AppData\\Local\\Android\\Ndk-r16b






Use case 1: Viewing a single 3D model on screen.

Use case 2: Viewing two 3D models overlapped over each other for comparison purposes.

Use case 3: Viewing two 3D models side by side for comparison purposes.
