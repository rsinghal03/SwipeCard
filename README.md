# SwipeCard

Demo gif show Tinder like swipeable card which contain text

<a href="https://imgflip.com/gif/3gjxp5"><img src="https://i.imgflip.com/3gjxp5.gif" title="made at imgflip.com"/></a>

# About the project

The project is designed using the MVP architecture pattern and Kotlin as development language. 
Unit test has been written for cardSwipePresenter

Libraries used are:
1. Dagger 2
2. RxJava
3. Retrofit
4. Jackson
5. Mockito

Dagger is used for dependency injection

The retorfit is used to make the api call while intercepting the response using okhttp interceptor and modifying the response to convert
into standard json format

RxJava is used to manage the network call on background thread and getting the result on main thread.

Jackson is used for deserialization.

Mockito used for mocking the object.
