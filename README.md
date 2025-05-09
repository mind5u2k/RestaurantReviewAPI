# RestaurantReviewAPI
This repository contains the project of building a Restaurant Review API that manages basic restaurant information and customer reviews


Steps to install and Run the project
Before following the below steps make sure git should be installed and running in your local machine

1) Clone the project using below command in local machine
   git clone -b main https://github.com/mind5u2k/RestaurantReviewAPI.git

2) Open Eclipse or STS and import as maven project
   Go to File Menu -> Select import -> select Existing Maven Projects
   
3) Then select the directory where your pom.xml file exist.
   
4) Once import done. Select project and right click and select maven -> update project
   (This will download your all dependencies available in pom.xml file)

5) To run the project
   a) Either select project and run as maven project
   b) Or Run RetaurantMgmtApplication.java file as java application.

6) Making build
   a) Select the project and right click.
   b) select Run as -> maven build
   c) in Goals : put 'clean install'
   d) apply the changes and build it.

Above command will create a jar file that can be run in any machine where java exist using below command:
1) Go to the directory where jar file exist and run below command
   java -jar RestaurantReview.jar

2) If you want to provide properties file at run time, use below command :
   java -jar <absolute_path>/RestaurantReview.jar --spring.config.location=<absolute_path>/application.properties
