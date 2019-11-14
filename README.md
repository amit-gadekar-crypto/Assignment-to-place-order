## **Shopmart Order Service**

This application provide two rest end points for order placing for shopmart merchant.

Rest End points are as follows

1. http://localhost:8080/order - HTTP Method POST - To place order <br>
        
        Request format : 
        {
          "cardId": 1001,
          "amount": 300,
          "products": [
            {
              "name": "Product1",
              "price": 10
            },
            {
              "name": "Product2",
              "price": 90
            }
          ],
          "address": {
            "city": "pune",
            "emailid": "amit@gmail.com",
            "mobilenumber": 9145457980,
            "name": "Amit Gadekar",
            "zip": "411035"
          }
        }
        
        * Sample values for cardId : 1001,1002,1003

2. http://localhost:8080/order/{transactionId} - HTTP method GET - To get Order details. <br>

        Expected response : id valid transactionId : 
        {
          "transId": "20191100010",
          "cardId": 1001,
          "amount": 300,
          "date": "2019-11-14T06:25:35.000+0000",
          "products": [
            {
              "name": "Product1",
              "price": 10
            },
            {
              "name": "Product2",
              "price": 90
            }
          ],
          "address": {
            "id": 10,
            "name": "Amit Gadekar",
            "zip": "411035",
            "city": "pune",
            "mobilenumber": 9145457980,
            "emailid": "amit@gmail.com"
          }
        }
        

        