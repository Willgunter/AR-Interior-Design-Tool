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
    - Exploring how to display a different thing than the default pawn
    
  - 8/30/2024
    - ⭐Tried to start printing out PointCloud data into a file - took a while but 
    got some of it to transfer to a FrameArray variable and read all the FrameArray into the debug log
    
  - 9/3/2024
    - Found a PCD file, need a way to visualize it
    - Setup a virtual environment using python's venv because we can't just run the python open3d library by itself for some reason
    - Uninstalled Python
    - Reinstalled Python
    - Rebooted laptop like 3 or 4 times just to set env variables
    - ⭐Used Python's Open3d library to visualize Point Cloud Coordinates
    - Got Python's Open3d library to visualize a mock PCD file with a small butterfly and some text

  - 9/4/2024
    - Visited research lab and had to fill out a bunch of forms
    - Figured out some way to read and write to some file (huge win btw)
    - Figured out how to write to the file, and how to access the file
    - ⭐Ran into a huge problem printing out the points but solved it and now get reasonably good Point Cloud images
  
    
  - 9/5/2024
    - Changed code up a bit to print out point cloud data a lot better
    - Experimented a bit with trying to scan water bottle. problem is that the water bottle is transparent
    - Further experimentation is needed with non-transparent objects, but I think now might be a good time
    to start looking at ways to do mesh-generation / object reconstruction / filtering
    - Would like to automate file wiping probably also because i do not like clicking a delete button
    
  - 9/6/2024
    - Started working on Raw Depth API codelab - ran into some issues but once I did some debugging it was
    something more simple than I thought.
    - Hopefully I will use a different model to increase the accuracy of the image (GMM possibly w/ EM, Mean Shift, or dbscan
    Note to self: go slow with the Raw Depth API Codelab to make sure you don't have any persistent error messages
    
  - 9/7/2024
    - Got Raw Depth pixels to display on screen along with camera image, very close to finishing Codelab
    ![unnamed.jpg](..%2F..%2F..%2FWILLGU%7E1%2FAppData%2FLocal%2FTemp%2Funnamed.jpg)
  
  - Finish raw depth codelab then do object reconstruction then figure out how to extract color
  - NOTE TO SELF: INSERT A POINT CLOUD IMAGE HERE, try again with point cloud data in 1) better lighting
  and 2) your whole room instead of just a small desk - (could talk abt how raw depth has improved something on resume)
  - NOTE TO SELF: FIGURE OUT HOW TO EXTRACT COLOR


Resources used:
  - (Basic Todo list tutorial in Kotlin) [https://github.com/philipplackner/TodoList/blob/master/app/src/main/java/com/example/todolist/MainActivity.kt]
  - (Google ARCore Documentation) [https://developers.google.com/ar/develop]
  - *(helpful post) [https://stackoverflow.com/questions/44749028/inflateexception-when-trying-to-use-a-snackbar]
  - [Open3d Python library] (https://www.open3d.org/docs/release/getting_started.html)
  - and
  - [PCD file (it says PointCloudLibrary with a small butterfly btw)] (https://pointclouds.org/documentation/tutorials/pcd_file_format.html)