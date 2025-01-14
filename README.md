# Phonewords

A java app to find phonewords from numbers.

## Description

Phonewords is an app to map phone numbers to common words defined in a dictionary. This is a command line program and no GUI is provided.

## Getting Started

### Dependencies

* JDK 17
* Gradle 8.12
* Junit 4

### Launching the program
* open the terminal and run
```
git clone https://github.com/evan-qin-xu/phonewords.git
```
* Go to the project directory
```
cd phonewords
```

* To launch the program
```
./gradle run
```

### Executing the program
* To run with default dictionary file
```
./gradlew run --console=plain
```
* To run with a custom dictionary file
```
./gradlew run -Pdictionary=<your-dictionary-file-path> --console=plain
```
e.g.
```
./gradlew run -Pdictionary=/Users/username/Desktop/my_dictionary.txt --console=plain
```
* To exit the program use
```
exit
```

## Help
Please send an email to [Evan Xu](mailto:evan.xuqin@gmail.com)

## Author
@Evan Xu &copy; All Rights Reserved
