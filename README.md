# bitmap-transformer

 this lab which implements a bitmap transformer Command Line Interface (CLI). It reads in a bitmap image from disk, run one or more color or  transformations and then write it out to a new file.

## How To Run

Run using CLI with `./gradlew run --args`. Arguments are:

* Input bmp filename. Loads from local `/resources` directory. No '.bmp' required.

* Output bmp filename. Also saves to `/resources` directory. No '.bmp' requred.

* Transformation to run. Choose from: `flipVertically`, `flipHorizontally`, or `addRedBorder`.
