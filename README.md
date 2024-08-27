An AR based app for Android that utilizes Google's ARCore library and open source 3D Object recognition models to scan and place objects in a real world environment

8/26/2024
- Figured out how to connect Android Studio to GitHub properly
- Started enabling AR in my app
  - Added a few lines in AndroidManifest.xml file
  - Added build dependencies (had to figure out how to translate from gradle.build file to
  library versions file)
  - Wrote code to check if ARCore is supported on device, to install necessary software if
  it is, and to request camera permission for app