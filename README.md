Headerizer
==========
Copyright © 2012 Ben Glasser

Headerizer is a utility that (when finished) will recursively sift through sub directories of a specified root inserting a header into files of a specified type.  Headerizer was inspired by Bart Massey's [emacs-copyright](https://github.com/BartMassey/emacs-copyright) and is released under a GPLv3.0 license

Current State
-------------
As of now, Hederizer has been realesed only as a commandline utility and can be run as follows:

**java -jar headerizer.jar -[r <file extention>] [ <source file> | <source dir> ] <header>**

the jar for this project can be found under [Downloads](https://github.com/BenGlasser/Headerizer/downloads)

note that there is little to no error handleing/fault tolerance right now so this may blow up in your face, but it hasn't lost a file yet ;)

Currently, Headerizer works by prepending the specified header at the begining of the specified file.  if the -r option is invoked and a directory is passed as an argument it will prepend the header to all files of the specified file type found in that directory and all sub directories.

Future Plans
------------
So far no future releases have been formalized, but it is my intention to incorporate the following features into Headerizer as the projects develops

*    GUI 
*    Insert headers into multiple file types at once
*    Automatic comment prefixing based on file type
*    Automatic name, date, and copyright entry
*    Support for multiple projects across a disjoint directory structure

any other ideas? you are welcome pass them along or implement them as you see fit.
