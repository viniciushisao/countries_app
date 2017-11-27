# Country list Android application

## Purpose

Use of fancy new technologies: MVVM, RxJava, LiveData and some old friends: Retrofit2, Gson.

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

1. I just saw on search it is not searching for inner strings but only in the beginning of the strings. E.g.: If you type "zi" it will search only for the begin of country name, so, it will show "Zimbabue, but the list suppose to show also Brazil.