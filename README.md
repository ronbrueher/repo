# Instructions for Building and Running Software Engineering Skills Assessment

## Build
1.	Download the BatchAnalyzer java project from github.
2.	From the BatchAnalyzer directory, enter the following two commands to set ownership and to build the project:

~~~
sudo chown -R USERNAME ./
build
~~~

## Run
1.  From the BatchAnalyzer directory, enter one of the following:

~~~
is-invalid-batch JSON-FILE
one-swap-recommendation JSON-FILE
two-swap-recommendation JSON-FILE
waste-metric JSON-FILE
~~~

2.  Execute units tests by entering the following:

~~~
test-runner
~~~

