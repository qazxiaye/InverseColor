This tool reverses colors of all images which are under working directory of the executable or under a directory given in the source. There should be no other file types under the directory. Generated files will be found in folder "gen" which will be under the directory mentioned above. Generated files' name will be the same as original images.

Usage: two possibilities

 1. change the value of static variable "path" in source code as the given directory mentioned above, then run it anywhere.
 2. set the value of static variable "path" as *System.getProperty("user.dir")*. Export runnable jar (which can be found in this respectory, ReverseColor.jar) and move this file to the desired directory containing images, then run. Note: There'll be exceptions launching directly in IDE in this case, due to other file types under the working directory.

<br><br>

这是一个将文件夹下所有图片颜色反转的小工具。可以设置具体路径指定文件夹，也可设置为科执行文件的当前工作路径。反色图片生成在路径下的新文件夹“gen”中，生成图片与原文件同名。

使用：
 
 1. 选项1：修改源码中变量 "path" 指定文件夹路径。
 2. 选项2：将 "path" 的值设为 *System.getProperty("user.dir")*，导出 runnable jar，将导出文件移至相应文件夹，并运行。
