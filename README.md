# EShop
An online sample backend application for e-commerce website created using Java, Dropwizard framework for REST API and MongoDB database.

# Prerequisite:
    1. Eclipse -> JDK, Maven
    2. MongoDB

# Steps to connect with DB:
    1. install MongoDB
    2. create a data folder for data to be stored (eg, F:/data)
    3. to start mongodb using cmd
       > cd C:\Program Files\MongoDB\Server\4.0\bin
       > mongod --dbpath "F:\data"
    4. using mongo compass gui(or robo mongo), create database, collection, and insert document with values

# Following collections are used: (MongoDB)

    seqNumber   - to generate userId and orderId
    customer    - to store customer details (both admin and customer)
    catalogue   - to store list of all products
    order       - stores purchase history of customers

# Following are the REST API's used:

    GET     /eshop                                  displays a welcome message along with the version details
	POST    /eshop/register                         receives user details and returns success message on successful registration. user id for each user is generated.
	POST    /eshop/customer                         receives user id and displays user details of the corresponding user
	POST    /eshop/additems                         allows only admin user to add items in the catalogue	
    GET     /eshop/product/catalogue		returns the items available in the catalogue
	POST    /eshop/product/purchase			allows single and bulk ordering based on user id, product id, quantity and emailId. Order id is generated for each order made.
    POST    /eshop/product/cancel			ased on user id and order id, cancel of product is made
	GET     /eshop/product/orders			returns the order history details
	
# REQUEST body for POST API's:

    1. /eshop/register
    COLLECTION: customer 
    REQUEST: { "userName":"moni", "password":"moni123", "type":"customer", "emailId":"moni@gmail.com" }

    2. /eshop/customer
    COLLECTION: customer
    REQUEST: { "userId":"102" }

    3. /eshop/additems
    COLLECTION: catalogue
    REQUEST: { "userId":102, "productId": 16, "productName": "Laptop", "price": "15000", "quantity": 2 }

    4. /eshop/product/purchase
    COLLECTION - order
    REQUEST: { "userId":100, "productId":11, "quantity":1, "emailId":"i.monikka@gmail.com" }

    5. /eshop/product/cancel
    COLLECTION - order
    REQUEST: { "userId":100, "orderId":501 }

# Steps to run jar file:
    1. execute maven clean and maven install
    2. once the jar file is created, run the following command to execute the jar
       > cd <target-directory where jar file is created>
       > java -jar EShop-0.0.1.jar server eShop.yml
