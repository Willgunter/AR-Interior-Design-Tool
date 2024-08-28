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
    - Modernized a deprecated way of requesting permissions (onRequestPermissionsResult --> registerForActivityResult)
    
  - 8/28/2024 
    - Delved into ARCore Session object and how it works
    - Solved Mesh library import problem
    - Ran into a ridiculously hard problem  (literally thought it was impossible) involving the Snackbar and the theme of the app,
    luckily a random StackOverflow post came to the rescue*
    - First working version on phone's app involving AR worked today

Resources used:
  - (Basic Todo list tutorial in Kotlin) [https://github.com/philipplackner/TodoList/blob/master/app/src/main/java/com/example/todolist/MainActivity.kt]
  - (Google ARCore Documentation) [https://developers.google.com/ar/develop]
  - *(helpful post) [https://stackoverflow.com/questions/44749028/inflateexception-when-trying-to-use-a-snackbar]