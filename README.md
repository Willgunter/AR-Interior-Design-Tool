Note: ADD PICTURES EVENTUALLY

An AR based app for Android that utilizes Google's ARCore library and open source 3D Object recognition models to scan and place objects in a real world environment



  - 8/26/2024
    - Figured out how to connect Android Studio to GitHub properly
    - Started enabling AR in my app
      - Added a few lines in AndroidManifest.xml file
      - Added build dependencies (had to figure out how to translate from gradle.build file to
      library versions file)
      - Wrote code to check if ARCore is supported on device, to install necessary software if
      it is, and to request camera permission for app

  - 8/27/2024
    - Copied Helper classes from ARCore tutorial codebase and fixed a bunch of file errors
    - Figured out how to update a deprecated function to request permission to use camera

Resources used:
  - (Basic Todo list tutorial in Kotlin) [https://github.com/philipplackner/TodoList/blob/master/app/src/main/java/com/example/todolist/MainActivity.kt]
  - (Google ARCore Documentation) [https://developers.google.com/ar/develop]