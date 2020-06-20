# Untitled Voltorb Flip Clone
by 11BelowStudio (https://github.com/11BelowStudio, https://11belowstudio.itch.io/)

yes, it's a clone of Voltorb Flip from pokemon heartgold/soulsilver. cba to hide the fact.

This game was originally made for a CE203 assignment, and I have made a few small changes
to it to make it compile as a .jar file.

but it's pretty much exactly in the state it was in when I handed it in.

Yep, it's open-source as well, and the source code is here: https://github.com/11BelowStudio/UntitledVoltorbFlipClone

## What you will need

* A half-decent computer
* A monitor (optional, but highly recommended)
* A mouse (you need to be able to move it and left-click at very least,
but right-clicking would be nice too)
* Java (this runs on Java 8)

## Downloading and running the game

* You need Java 8 in order to play this game.
* Download the 'UntitledVoltorbFlipClone Zipped.zip' file
    * From the 'Compiled Versions' folder if you're downloading this from the repo
    * If you downloaded this from itch.io, that's the only download available on there
* Unzip it whereever you want to unzip it to
* Open the 'UntitledVoltorbFlipClone' folder from inside there
* DO NOT TOUCH THE 'Super Secret Files (pls no delet)' FOLDER
* CLick on 'UntitledVoltorbFlipClone.jar' to play the game!

## How To Play

### The objective:
* Reveal all of the '2' and '3' cards on the board.
    * Your score will be multiplied by the value of the card you reveal
    * You don't need to reveal the '1' cards, but you can reveal them if you want to
* Avoid revealing any bomb cards.
    * They will explode in your face, and you will look very silly when that happens.
* Get a high score or something I guess

### Things that may help you to not lose:
* Every row/column has a panel with information about what is in the row.
    * It shows the sum of the values of the point cards in that row/column,
    as well as the count of bombs in that row/column.
* Right-clicking the squares for the checkerboard pattern on each card
will allow you to take a note of what you think each card holds.
    * You can have multiple notes on a single card
    * Where to click for each note
        * Top-left: bomb
        * Top-right: 1
        * Bottom-left: 2
        * Bottom-right: 3.
    * Right-clicking that square again will hide that note again.
    
### How to get a high score:
* Revealing a card will multiply your current score by the amount on that card
    * However, a bomb card counts as a 'x0' multiplier for your score, and will end the game.
* After you have completed a level, you will have the option to 'bank' your score.
    * If you choose to 'bank' it, your current score will be added to your 'banked' score,
    and your current score will be reset to 0.
    * However, only your 'banked' score counts towards your final score when you lose the game,
    so you should bear that in mind if you're going for a high score.

### Super Helpful Informative Tips
* If a row/column has 0 bombs in it, it is safe to reveal all the cards in that row/column​
* If a row/column has 5 bombs in it (somehow), don't bother touching it.
* If the sum of the points and the bombs in a row/column is equal to 5,
all the point cards in that row/column will be 1s.
    * This means that you don't really need to reveal anything in that column,
    as it'll either be useless (a 1) or a bomb (which is also useless)
    * Same principle applies if the row/column has Y unrevealed cards,
    and the sum of the total score for the row/column (minus the revealed score)
    plus bombs is equal to Y
* Yes, you will sometimes need to make lucky guesses.
* Bank your points if you don't think you'll survive the next level.
    * After all, you'll lose eventually, and you don't want all your hard work to go to waste (probably)

## Credits

* Programming, Art, etc:
    * 11BelowStudio
    * Code used to get the image into the .JAR file provided by JB Nizet on StackOverflow (https://stackoverflow.com/a/8362018)
* Original game concept:
    * This game is essentially a recreation of the 'Voltorb Flip' minigame
    from the non-Japanese versions of Pokemon HeartGold and Pokemon SoulSilver
    (developed by Game Freak, published by Nintendo, 2010). 
    Further information about it can be read about it here: https://bulbapedia.bulbagarden.net/wiki/Voltorb_Flip
        * I have made a few minor changes to it (different visuals,
        different controls, it's playable on PC,
        adding an extra element of risk vs reward with the scores, etc),
        however, for all intents and purposes,
        this game is pretty much a copy of that game.


## License
MIT License

Copyright (c) 2020 R. Lowe

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
