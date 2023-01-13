package main;

public class ConflictTokens {
    int conflictTokensNumber;
    int flippedConflictTokensNumber;

    ConflictTokens(int n){
        conflictTokensNumber = n;
        flippedConflictTokensNumber = 0;
        if(n == 2) conflictTokensNumber++;
        if(n == 7) conflictTokensNumber--;
    }

    public boolean allConflictTokensFlipped() {
        if(conflictTokensNumber - flippedConflictTokensNumber == 0){
            return true;
        }
        return false;
    }

    public void flipConflictTokens(int n){
        flippedConflictTokensNumber += n;
    }
}
