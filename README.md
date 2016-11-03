This tool reverses colors of all images which are under working directory of the executable or under a directory given in the source. There should be no other file types under the directory. Generated files will be found in folder "gen" which will be under the directory mentioned above. Generated files' name will be the same as original images.

Usage: two possibilities

 1. change the value of static variable "path" in source code as the given directory mentioned above, then run it anywhere.
 2. set the value of static variable "path" as *System.getProperty("user.dir")*. Export runnable jar (which can be found in this respectory, ReverseColor.jar) and move this file to the desired directory containing images, then run. Note: There'll be exceptions launching directly in IDE in this case, due to other file types under the working directory.
