# Encryption-Decryption

![App Demo](https://j.gifs.com/L7Lo5v.gif)
#### A simple java program to encrypt and decrypt text input, based on the encryption key given. 
There are two encryption/decrytpion algorithms available:

1. **Shift** -> it shifts each letter by the specified number (the key) according to its order in the alphabet in circle;
2. **Unicode** -> performs encryption/decryption based on the Unicode table. 

The app is controlled from the terminal.

## Table of content

- 🚀 [Getting Started](#getting-started-🚀)

- 🕹 [Usage](#usage-🕹)  

- 🏗 [Built With](#built-with-🏗) 

- ➕ [Contributing](#contributing-➕)

- 🛎 [Get Help](#get-help-🛎) 

- ⚡️ [Motivation](#motivation-⚡️)

- 🙏🏻 [Acknowledgments](#acknowledgements-🙏🏻)

## Getting Started 🚀

There are 3 steps to start playing with the app:
1. Clone the repository.
2. Compile the program, using "javac Application.java" command when in directory where Application.java file lives on your machine.
3. Launch the program using commands and additional rules explained below.

**Commands:**
- "**-mode**" -> accepts 2 possible strings: "**enc**" (encryption) or "**dec**" (decryption);
- "**-key**" -> accepts integers as the key of encryption/decryption;
- "**-data**" -> accepts a strings as the input text to encrypt/decrypt;
- "**-in**" -> accepts a string as the name of the source .txt file to read the data to encrypt/decrypt from;
- "**-out**" -> accepts a string as the name of the output .txt file to write the result of encryption/decryption to;
- "**-alg**" -> accepts 2 possible strings: "**shift**" (using shifting algorithm to encrypt/decrypt) or "**unicode**" (using unicode algorithm to encrypt/decrypt).

**Additional rules:**
1. If there is no -mode, the program should work in enc mode.
2. If there is no -key, the program will consider that key = 0.
3. The program will read data from -data or from a file written in the -in argument. That's why you can't have both -data and -in arguments simultaneously, only one of them.
4. If there is no -data and there is no -in the program will assume that the data is an empty string.
5. If there is no -out argument, the program will print data to the standard output.
6. If there are both -data and -in arguments, the program will prefer -data over -in.
7. If there is no -alg the program will default to shift.
8. Remember that in case of shift algorithm you need to encode only English letters (from 'a' to 'z' as the first circle and from 'A' to 'Z' as the second circle i.e. after 'z' comes 'a' and after 'Z" comes 'A').
9. The arguments may be in different order.
10. If there is a non-standard situation (an input file does not exist or an argument doesn’t have a value), the program will display a clear message about the problem.

Please see the examples of how to use the application in the "Usage" section below.

## Usage 🕹

**Example 1**

**Input:**  
java Application -mode enc -key 7 -data "Welcome to Encryption-Decryption" -alg unicode
  
**Output:**  
The input is: Welcome to Encryption-Decryption  
The result is: ^lsjvtl'{v'Lujy w{pvu4Kljy w{pvu

**Example 2**

**Input:**  
java Application -mode enc -in road_to_treasure.txt -out protected.txt -key 7 -alg unicode

This command gets data from the file road_to_treasure.txt, encrypt the data with the key 5, create a file called protected.txt and write ciphertext to it.

**Output:**  
The input to encrypt is: "I hope you enjoy learning java"  
The result is: )P'ovwl' v|'luqv 'slhyupun'qh}h)

**Example 3**

**Input:**  
java Application -key 5 -alg shift -data "Bjqhtrj yt jshwduynts-ijhwduynts" -mode dec

**Output:**  
The input is: Bjqhtrj yt jshwduynts-ijhwduynts  
The result is: Welcome to encryption-decryption

## Built With 🏗
 [![Java Badge](https://img.shields.io/badge/-Java-007396?style=for-the-badge&labelColor=white&logo=java&logoColor=007396)](https://www.java.com/en/)

Each stage of the project development I have completed to reach the end result you can find below:

### Stage 1/6: Encrypted!

For the first stage, you need to manually encrypt the message "we found a treasure!" and print only the ciphertext (in lower case). To encrypt the message, replace each letter with the letter that is in the corresponding position from the end of the English alphabet (a→z, b→y, c→x, ... x→c, y →b, z→a). Do not replace spaces or the exclamation mark. Use the given template to your program to print the ciphertext instead of the original message. The output should look like ## ##### # ########! where # is a lower-case English letter.


### Stage 2/6: Knowledge is key

Write a program that reads an English message and an integer number (key) from the standard input and shifts each letter by the specified number according to its order in the alphabet. If you reach the end of the alphabet, start back at the beginning (a follows z).

The English alphabet is below:

abcdefghijklmnopqrstuvwxyz 

The program should not modify non-letter characters.

The key is assumed to mean that if a person knows the value of the key, he or she will be able to decrypt the text, and if he or she does not know, he or she will not be able to decrypt the text. It's like a real key that can open up access to the message text.

Input example: welcome to hyperskill 5

Output example: bjqhtrj yt mdujwxpnqq


### Stage 3/6: Decrypted!

In this stage, you need to support decryption in your program. The decryption is simply the inverse of encryption, following the same steps but reversing the order in which the keys are applied. Write a program that reads three lines from the standard input: a target operation (enc - encryption, dec - decryption), a message or a cyphertext, and a key to encrypt/decrypt messages. All non-letter characters must be encrypted as well as regular letters. Decompose your program using methods to make it easy to understand and edit later. One method should encrypt a message and another one should decrypt it according to a key.


### Stage 4/6: I command you

Modify the previous program to work with command-line arguments instead of the standard input. The program must parse three arguments: -mode, -key and -data. The first argument should determine the program’s mode (enc - encryption, dec - decryption). The second argument is an integer key to modify the message, and the third argument is a text or ciphertext within quotes to encrypt or decrypt.

All the arguments are guaranteed to be passed to the program. If for some reason it turns out to be wrong:

If there is no -mode, the program should work in enc mode. If there is no -key, the program should consider that key = 0. If there is no -data, the program should assume that the data is an empty string. Keep in mind that arguments may be in different order. For example, -mode enc may be at the end, at the beginning or in the middle of arguments array.


### Stage 5/6: X-files

At this stage, you need to add the ability to read and write original and cipher data to files. The program must parse two additional arguments -in and -out to specify the full name of a file to read data and to write the result. Arguments -mode, -key, and -data should still work as before.

Your program should read data from -data or from a file written in the -in argument. That's why you can't have both -data and -in arguments simultaneously, only one of them.

If there is no -mode, the program should work in enc mode. If there is no -key, the program should consider that key = 0. If there is no -data, and there is no -in the program should assume that the data is an empty string. If there is no -out argument, the program must print data to the standard output. If there are both -data and -in arguments, your program should prefer -data over -in. If there is a non-standard situation (an input file does not exist or an argument doesn’t have a value), the program should not fail. Instead, it must display a clear message about the problem and stop successfully. The message should contain the word "Error" in any case.


### Stage 6/6: Choices, choices

Extend your program by adding different algorithms to encode/decode data. The first one would be shifting algorithm (it shifts each letter by the specified number according to its order in the alphabet in circle). The second one would be based on Unicode table, like in the previous stage.

When starting the program, the necessary algorithm should be specified by an argument (-alg). The first algorithm should be named shift, the second one should be named unicode. If there is no -alg you should default it to shift.

Remember that in case of shift algorithm you need to encode only English letters (from 'a' to 'z' as the first circle and from 'A' to 'Z' as the second circle i.e. after 'z' comes 'a' and after 'Z" comes 'A').

To complete this stage, we recommend that you create a set of classes and interfaces for encryption and decryption algorithms.

## Contributing ➕

#### Issues

In the case of a bug report, bugfix or a suggestions, please feel very free to open an issue.

#### Pull request

Pull requests are always welcome, and I'll do my best to do reviews as fast as I can.

## Get Help 🛎

- Contact me on krasy8@gmail.com 📬 

- If appropriate, [open an issue](https://github.com/Krasy8/Encryption-Decryption/issues) on GitHub 

## Motivation ⚡️

This is my first project completed as a result of taking up coding in java. I have learnt a lot when working on it and enjoyed the whole journey very much. After learning basics on a bootcamp course I couldn't wait to apply what I had learnt to an actual project, which I could show on my GitHub page and this application turned out to be a perfect first step to test my knowledge in practice.

I strongly recommend https://hyperskill.org/tracks to anyone who is interested in learning how to code or who wants to advance their coding skills further. You will be able to find here a very specific road map to reach your goal, depending on what programming language you are interested in and how advanced you are on your learning journey already.

## Acknowledgements 🙏🏻

A **HUGE THANK YOU** to JetBrains Academy for the project guidelines on:

https://hyperskill.org/projects/46?track=1

I found this website to be very helpful when learning how to code in java, where the knowledge is explained clearly and "packaged" in the ideal-sized portions for the specific task you are faced with. Each stage of the project is tested by built-in tests so you can be sure it meets the expected standard.

**The best way to learn java through developing a project!** 👍

You will be able to find a lot of different projects ideas (with different levels of difficulty!) and very clear development path for each of them with necessary knowledge support delivered in perfectly measured doses. There is a huge community attached to it as well so you can always share your experience and seek help from others. 
