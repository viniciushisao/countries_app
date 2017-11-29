# Country list Android application

## Purpose

Use of fancy new technologies: [MVVM](https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93viewmodel),
[RxJava](https://github.com/ReactiveX/RxJava), [LiveData](https://developer.android.com/topic/libraries/architecture/livedata.html)
and some old friends: [Retrofit2](http://square.github.io/retrofit/), [Gson](https://github.com/google/gson).

Well, mainly new [Android Architecture Components](https://developer.android.com/topic/libraries/architecture/index.html)

You will notice that for sure I did not focus on other stuff but on Architecture.

## TODO

1. Handle connection errors.
1. Use Room to store data.
1. Work on UI.
1. Improve search list. Nowadays the list is pretty simple and does not implement material design.
1. Improve SVG image conversor. The one I am using today is pretty old.
1. Improve the static Google Image download. I am not comfortable in setting the user id in the URL, maybe using Google SDK?
1. Landscape and tablet view are not good but as I said, I did not focus on it.

## Bug

1. I just saw on search it is not searching for inner strings but only in the beginning of the
strings. E.g.: If you type "zi" it will search only for the begin of country name, so, it will show
"Zimbabue, but the list suppose to show also Brazil.

## Architecture discussion

1. One of the prerequisites of this exercise was in the first screen
of the application the app should retrieve a list of all countries and
then show it to search. What I usually do is to discuss it when I believe I have a better idea.
Well, since I did not have anyone to discuss, I implemented my solution: In a static way
provide the list of countries and then, in the second screen, retrieve the detail of the country.
These are my points:

   1. The API provided did not have a call that retrieves only a list of country names. You should
   get a list of all countries and its details. If we are thinking in saving data transmition, this
   is huge (the complete list would get around 250kb)
   1. Again, if are thinking in saving data transmission, we don`t want to start our application
   retrieving data. We do as much as we can without internet calls.
   1. If one day the list of countries of the world changes, our app must be updated.
   1. For the purpose of the app, all the calls were made.
   1. The internet calls will be optimized. Only retrieves what is really necessary.
