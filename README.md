This tool is for color reversing of a batch of images. Generated files will be found in folder "gen" under working directory. Reversed files' names will be the same as original images.

<br>

Usage: 

 - if there's no parameter, all image files under working directory will be reversed.

 - otherwise, each image file in parameters will be reversed.

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

