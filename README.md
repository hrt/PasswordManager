A very simple but infinitely useful program used to generate unique and random passwords on the fly.

Example usage:

```
> java Main facebook.com
> *******
```

The result will be in your clipboard - a password uniquely generated using random numbers of seeds made by the site and your master key which you provide upon every program launch.

The password will have minimum requirements defined within the function ```minimumRequirments(String pw)``` and length of at least ```PASSWORD_LENGTH```.


### How to use

To run the program use
```
java Main <INSERT_WEBSITE_DOMAIN>
```

After the first line is executed, enter your master key into the invisible field and press enter to have the password copied into your clipboard.


### Compiling

Simply run

```
javac Main.java Util.java
```

To compile everything (including Test.java) then run

```
javac *.java
```


### Testing

Compile everything and run

```
java Test
```