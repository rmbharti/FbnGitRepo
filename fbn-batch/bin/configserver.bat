# command below does not works it looks for spring boot jar files

#java -cp ".;C:\Users\admin\Desktop\AWS-Workspace\fbn-applib\lib\fbn-config-server\*.jar"  -jar ..\..\fbn-applib\jars\fbn-server-config-0.0.1-SNAPSHOT.jar

# move file to docker toolbox shared folder
# this can also be acheived through command
# VBoxManage sharedfolder add "VM name" --name "sharename" --hostpath "C:\test"

#copy ..\..\fbn-config-server\target\fbn-server-config-0.0.1-SNAPSHOT.jar ..\..\fbn-dct-shared


java -jar  -jar fbn-server-config-0.0.1-SNAPSHOT.jar


# Command to pass URI info dynamically
java -jar -Dspring.cloud.config.server.git.uri=file:///home/ubuntu/GitRepo fbn-server-config-0.0.1-SNAPSHOT.jar

# Command to run process in background
nohup bash -c "java -jar -Dspring.cloud.config.server.git.uri=file:///home/ubuntu/GitRepo fbn-server-config-0.0.1-SNAPSHOT.jar" 

# Running program in backgroun in linux
nohup java -jar /web/server.jar &

nohup java -jar -Dspring.cloud.config.server.git.uri=/home/ubuntu/GitRepo fbn-server-config-0.0.1-SNAPSHOT.jar & > configlog.txt


here's one crucial thing you need to do after adding a &. The process is still linked to the terminal. You need to run disown after running the java command.

java -jar yourApp.jar &> log.txt
disown
Now, you can close the terminal.


Did you try putting & at the end of the command line? For example:

java -jar mySocketApp.jar &
You can also use bg and fg commands to send a process to background and foreground. You can pause the running process by CTRL+Z.


