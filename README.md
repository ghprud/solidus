# solidus

1. Build/Run instructions for the services
	a. Assumption: Java in installed and the required environment variables are set
	b. The project uses spring boot, and in memory database. 
	c. The project is set up to run using maven. I checked in the required maven binary files to run the
		project. 
	d. From the root folder (the folder where pom.xml is placed), run the following command
		./apache-maven-3.6.3/bin/mvn spring-boot:run  (this will start the server on the defualt port: 8080)
	e. curl commands can be used to test sending the messages and the digests, after the server is started.
		i. curl -X POST -H "Content-Type: application/json" -d '{"message": "foo"}' http://localhost:8080/messages
		ii. curl  -v http://localhost:8080/messages/2c26b46b68ffc68ff99b453c1d30413413422d706483bfa0f98a5e886266e7ae

2. Gift card problem (Assumption: java is installed and required environment variables are set)
	i. cd giftcard (from the root)
	ii. javac GiftCard.java
	iii. java GiftCard <absolute_path_of_the_file> <gifc_card_value>

3. The time complexity for the gift card problem is linear O(n).


3. If many requests come in per second, there are a couple of ways this can be solved:
	a. Add a messaging layer in between the client and the backend services. 
	b. If using messaging layer is not an option, a thread pool can be used on the backend to manage
		the incoming requests. 
	c. Using messaging layer is the best option here. 