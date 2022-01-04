# JavaUdpServerClient
A Java implementation of a Datagram UDP Server and Client that can send and recieve UDP packets between each other. A copy of this blog http://helloraspberrypi.blogspot.com/2016/05/java-datagramudp-server-and-client-run.html

Clone the repo and using a terminal run 

`javac JavaUdpServer.java`

`javac JavaUdpClient.java`

Open up two terminals and in one run 

`java JavaUdpServer`

then in the other run

`java JavaUdpClient`

You should then see a line in the JavaUdpServer terminal saying

`Request from: /127.0.0.1:<<random port>>`

The client will show something like this

`Runtime Java: 11.0.7+10-post-Ubuntu-2ubuntu218.04
JavaUdpClient running, connect to: 127.0.0.1:4445
Thu May 21 11:14:58 BST 2020`
