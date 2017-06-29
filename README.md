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
javac Main.java
```


### Testing

This program was just hacked together on the go since a site really pushed me to the limits with password requirements. Therefore I never actually wrote some automated tests. However I have been reliably using this program over the course of 1.5 years of which only one site has complained about password requirements. Just posting the source code out there if anyone else wishes to just use it.