This tool is for color reversing of a batch of images. Generated files will be found in folder "gen" under working directory. Reversed files' name will be the same as their source image.

<br>

Usage: 

 - if no parameter has been passed, all images under working directory will be source image to be reversed.

 - otherwise, all images in parameters will be source image to be reversed.

<br>

Run:

 - **maven**

 1. `mvn package`

 2. `java -jar target/ReverseColor-1.0.0.jar [optional: image files]`

 or

 - **gradle**

 1. `gradle jar`

 2. `java -jar build/libs/ReverseColor.jar [optional: image files]`

<br>
 - original image

 ![](NetTopology.ppm.gif)

 - reversed image

 ![](gen/NetTopology.ppm.gif)

