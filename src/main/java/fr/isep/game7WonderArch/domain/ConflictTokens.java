package fr.isep.game7WonderArch.domain;

public class ConflictTokens {
    int conflictTokensNumber;
    int flippedConflictTokensNumber;

    public ConflictTokens(int n){
        conflictTokensNumber = n;
        flippedConflictTokensNumber = 0;
        if(n == 2) conflictTokensNumber++;
        if(n == 7) conflictTokensNumber--;
    }

    public boolean allConflictTokensFlipped() {
        if(conflictTokensNumber == flippedConflictTokensNumber){
            this.flippedConflictTokensNumber = 0;
            return true;
        }
        return false;
    }

    public void flipConflictTokens(int n){
        flippedConflictTokensNumber += n;
        if(flippedConflictTokensNumber > this.conflictTokensNumber)
        {
            flippedConflictTokensNumber = this.conflictTokensNumber;
        }
    }
}
