# SSL Demo Application

This is the accompanying project code for the blog post [Secure Spring Boot Applications with TLS and HTTP/2](https://www.novatec-gmbh.de/en/blog/spring-boot-applications-tls-http2/) 
on [blog.novatec-gmbh.de](https://blog.novatec-gmbh.de).

## System Requirements

* Java 11 SDK

## Using this demo project

You can use this project 

1. directly without changing anything here.
The only thing you have to do is to import the root certificate in 
your web browser as new authority. The root certificate can be found
in *setup_ca/ca.pem*. After importing this you can start the application and 
navigate to [https://localhost:8443](https://localhost:8443) in your web browser.

2. or with setting up a new private certificate authority first. Then you have to follow the
explanations of the next sections.  

## Setting up the private CA

To setup the private certificate authority with root certificate and to create the valid
server certificate please run the corresponding shell script *setup_ca.sh* (linux) / *setup_ca.cmd* (windows) 
in sub directory *setup_ca*.

This script creates the required sub directories and performs all the steps using keytool
as described in the blog post.

After executing the script you will find the important files here:

* _setup_ca/root-ca_: Here you find the root certificate *ca.pem* that you have to import as new authority in your web browser
* _setup_ca/server_: Here you find the key store *server.jks* containing the root and server certificates. 
This has to be copied to the directory *src/main/resources*. The existing key store can be overwritten.

After you have completed all these steps you can start the application and 
navigate to [https://localhost:8443](https://localhost:8443) in your web browser.
   
