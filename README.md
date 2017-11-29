# README #



### How to run/test the application ###

* Clone the repository:  git@github.com:paulohenriquefreitas/jpa-hibernate.git
* Build : mvn clean dependency:copy-dependencies package
* Run the application with maven command: mvn spring-boot:run
* Run the tests: mvn test


### The resources  ###

Product
* localhost:8080/jpahibernate/product/save      - method POST   Save product. 
Simple Product ```{"name":"dress","description":"red"}``` 
Relacional Product ``` {"name":"clothes","description":"parent","principal":{"name":"dress","description":"child"},"images":[{"type":"MM"}]}```
* localhost:8080/jpahibernate/product?full=true   - method GET    Get  product list and all relationships.
* localhost:8080/jpahibernate/product?full=false   - method GET    Get  product list without relationships.
* localhost:8080/jpahibernate/product/1?full=true        - method GET    Get  product by id and all relationships.
* localhost:8080/jpahibernate/product/1?full=true     - method GET    Get  product by id without relationships.
* localhost:8080/jpahibernate/product/update    - method PUT    Update product.
``` {"product_id": 2,"name": "dress","description": "yellow"}```
* localhost:8080/jpahibernate/product/1         - method DELETE Delete product by id.

Images

* localhost:8080/jpahibernate/product/image/save   - method POST   Save image.
```{"type":"PP"}```
* localhost:8080/jpahibernate/product/image        - method GET    Get  image list.
* localhost:8080/jpahibernate/product/image/1      - method GET    Get  image by id.
* localhost:8080/jpahibernate/product/image/update - method PUT    Update image.
```{"image_id": 1,"type": "MM"}```
* localhost:8080/jpahibernate/product/image/1      - method DELETE Delete image by id.

### Conclusion  ###

There are others technologies that I would have used. I appreciate the way Retrofit perform http handle REST API(Although its more used in Android application) .
For high volume of data, NOSQL would be better, because it is better scalable. I would have used Mongo for persistence.  
I didn't implement Integration Tests because memory database may have different behavior from real production database.
  

OBS: Here's how to configure Lombok in Eclipse if necessary:
Right click do not jar lombok (lombok-1.16.2.jar).
Run as -> Java Application.
Opening an installation window, specify the Eclipse path.
Click Install / Refresh.
Restart eclipse in hand (Not by: File -> Restart).