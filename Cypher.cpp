/*
 * Gus Pham
 * Program 5; This program will create a forward and reverse cipher based on the keyword. Then give
 * choices to encode or decode messages.
 */


#include <iostream>
using namespace std;

//proto type
bool duplicate(char message[]);
int main();
void option1(char forwardCipher[], char reverseCipher[], char message[]);
void option2(char forwardCipher[],char encodeMessage[]);
void option3(char reverseCipher[], char decodeMessage[]);

int main() {
    int choice;
    char message[1001];
    char encodeMessage[1001];
    char decodeMessage[1001];
    char forwardCipher[27];
    char reverseCipher[27];
    forwardCipher[26] = '\0';
    reverseCipher[26] ='\0';

    cout << "Welcome To The Keyword Cypher Program!" << endl;
    cout << "Let first make a cipher!!" << endl;
    cout<<"Enter the key word (no duplicate characters): ";
    cin>>message;
    while (duplicate(message)){
        cout<<"Duplicated Character Found!"<<endl;
        cout<<"Enter other message: ";
        cin>>message;
    }
    option1(forwardCipher, reverseCipher, message);

    do {






        cout << "What do you want to do do?" << endl;
        cout << "(1) Create a new keyword cipher\n"
                "(2) Encode a message\n"
                "(3) Decode a message\n"
                "(4) Exit the program\n"
                "Enter your choice: ";
        cin >> choice;
        while (choice <1 || choice > 4){
            cout<<"Enter a valid choice: ";
            cin>>choice;
        }
        if (choice ==1){
            cout<<"Enter the key word (no duplicate characters): ";
            cin>>message;
            while (duplicate(message)){
                cout<<"Duplicated Character Found!"<<endl;
                cout<<"Enter other message: ";
                cin>>message;
            }
            option1(forwardCipher, reverseCipher, message);
        }else if (choice ==2){
            cout<<"Enter the message you want to encode: ";
            cin>>encodeMessage;
            option2(forwardCipher, encodeMessage);

        }else if(choice==3){
            cout<<"Enter the message you want to encode: ";
            cin>>decodeMessage;
            option3(reverseCipher, decodeMessage);

        }
    } while (choice != 4);
    cout<<"Exited the program! Byebye!"<<endl;

}


//helping funtion
bool duplicate(char message[]){
    int duplicateAl[26];
    for (int i = 0; i<26 ; ++i) {
        duplicateAl[i] = 0;
    }
    for (int ix = 0; message[ix] != '\0' ; ++ix) {
        duplicateAl[message[ix]-'A']++ ;
    }
    for (int iD = 0; iD < 26; ++iD) {
        if (duplicateAl[iD] > 1){
            return true;
        }
    }
    return false;
}
void option1(char forwardCipher[], char reverseCipher[], char message[]){

    //create forward cipher
    int index = 0;
    char alphabet[26];
    bool usedLetter[26] = {false};
    for (int i = 0; i < 26; ++i) {
        alphabet[i] = 'A' + i;
    }
    //fill forward cipher with keyword
    for (int i = 0; message[i] != '\0'; ++i) {
        if (!usedLetter[message[i]-'A']) {
            forwardCipher[index++] = message[i];
            usedLetter[message[i]-'A'] = true;
        }
    }
    //fill in remaining letters of the alphabet
    for (int i = 0; i < 26; ++i) {
        if (!usedLetter[i]) {     //check for use letter and skip to next letter with + i;
            forwardCipher[index++] = 'A' + i;
        }
    }
    //reverse cipher
    for (int i = 0; i < 26; ++i) {
        //find the position of the alphabet letter in the forwardCipher
        char letter = forwardCipher[i];
        reverseCipher[letter - 'A'] = 'A' + i;      //put it in the correspond position
    }
}


void option2(char forwardCipher[],char encodeMessage[]){
    char result[1001];
    int i;
    for ( i = 0; encodeMessage[i] != '\0' ; ++i) {
        result[i] = forwardCipher[encodeMessage[i] - 'A'];
    }
    result[i] = '\0';
    cout<<result<<endl;
}
 void option3(char reverseCipher[], char decodeMessage[]){
     char result[1001];
     int i;
     for ( i = 0; decodeMessage[i] != '\0' ; ++i) {
         result[i] = reverseCipher[decodeMessage[i] - 'A'];
     }
     result[i] = '\0';
     cout<<result<<endl;
}

