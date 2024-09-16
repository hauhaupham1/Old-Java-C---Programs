//Gus Pham
//Program3 Convert between rectangular and polar coordinates, and calculate the distance between 2 points.
//It also helps to calculate which speed and direction to travel to reach the wanted destination, or calculate
//final destination after a time of traveling in a direction.



#include <iostream>
using namespace std;


//prototypes
void XYCoordinate(double &x, double &y);
void polarCoordinates(double &radius, double &direction);
void cusOpt1();
double engineerOpt1(double _x1, double _y1, double _x2, double _y2);
void cusOpt2();
double engineerOpt2(double _x, double _y, double &radius, double &direction);
void cusOpt3();
void engineerOpt3(double radius, double direction, double &x, double &y);
int main();
void phase1();
void phase2Opt1();
void phase2Engineer1(double radius1, double direction1, double radius2, double direction2, double &radius, double &direction);
void phase2Opt2();
void phase2Engineer2(double speed, double time, double directionHeading, double radiusInitial, double directionInitial, double &radiusDestination, double &directionDestination);



int main(){
    int choice;
    cout << "Hello People!" << endl;
    cout<<"Welcome to the calculation program which is used to calculate speed direction,etc... !";

    cout<<"This is the menu."<<endl;
    do {
        cout<<"(1) Speed and Direction\n"
              "(2) Destination\n"
              "(3) Basic Calculations\n"
              "(4) Quit"<<endl;
        cout<<"Enter your choice: ";
        cin>>choice;

        while(choice >4 || choice < 1){
            cout<<"Please enter a valid choice: ";
            cin>> choice;
        }
        if (choice ==1){
            phase2Opt1();
            cout<<"Done"<<endl;
        } else if (choice ==2){
            phase2Opt2();
            cout<<"Done"<<endl;

        } else if(choice ==3){
            phase1();
        }
    } while(choice != 4);
    cout<<"Exited the program! Have a good day!";

}

void phase1() {
    int choice;


    do {
        cout<<"What would you like to do today?"<<endl;
        cout<<"(1) Compute and display the distance between 2 point in rectangular. (in miles).\n"
              "(2) Compute and display the equivalent location in polar coordinates (distance in miles, and direction in degrees)\n "
              "for rectangular coordinates (x and y, in miles).\n"
              "(3) Compute and display the equivalent rectangular for polar coordinates.\n"
              "(4) Exit: ";
        cin>>choice;
        while (choice >4 || choice <1){
            cout<<"Please enter a valid choice: ";
            cin>>choice;
        }
        if (choice ==1){
            cusOpt1();

        } else if (choice ==2){
            cusOpt2();

        } else if (choice ==3){
            cusOpt3();
        }

    } while (choice != 4);
    cout<<"Exited the program! Goodbye!"<<endl;
}

//2 sub programs for xy coordinates and polar coordinates
void XYCoordinate(double &x, double &y){
    cout<<"Enter value for x: ";
    cin>> x;
    cout<<"Enter value for y: ";
    cin>>y;
}
void polarCoordinates(double &radius, double &direction){
    cout<<"Enter value for radius(miles): ";
    cin>> radius;
    while (radius <= 0){
        cout<<"Please enter a positive value for radius: ";
        cin>>radius;
    }

    cout<<"Enter value for direction (degrees): ";
    cin>>direction;
    while(direction<-360 || direction >360){
        cout<<"Please enter a value in a range of -360 to 360: ";
        cin>>direction;
    }
}
//end of 2 subprograms for xy coordinates and polar coordinates.

//2 subprograms for option 1
void cusOpt1(){
    double x1, y1, x2, y2;
    cout << "Enter coordinates for the first point:" << endl;
    XYCoordinate(x1, y1);
    cout << "Enter coordinates for the second point:" << endl;
    XYCoordinate(x2, y2);

    cout<<"The distance is: " << engineerOpt1(x1, y1, x2, y2) <<" mile(s)"<< endl;

}
double engineerOpt1(double _x1, double _y1, double _x2, double _y2){
    return sqrt(pow(_x2-_x1,2) + pow(_y2-_y1,2));
}

//end of 2 subprograms for option 1

//2 subprograms for option 2
void cusOpt2(){
    double x,y;
    double radius, direction;
    cout << "Enter rectangular coordinates:" << endl;
    XYCoordinate(x, y);
    engineerOpt2(x, y, radius, direction);
    cout<<"Polar coordinates: "<< radius<< " miles, " << direction << " degrees"<< endl;
}
double engineerOpt2(double _x, double _y, double &radius, double &direction){
    double PI = 3.14;
    radius = sqrt(pow(_x,2) + pow(_y,2));
    if (_x != 0) {
        direction = atan(_y / _x) * 180 / M_PI;

        if (_x < 0) {
            direction += 180;
        }
    } else {
        if (_y>0){
            direction = 90;
        } else {
            direction = -90;
        }
    }
}
//end of 2 subprograms for option 2.

//subprograms for option 3
void cusOpt3(){
    double radius, direction, x , y;
    polarCoordinates(radius, direction);
    engineerOpt3(radius, direction, x , y);
    cout<<"Rectangular Coordinates: "<< x << ", "<<y << endl;
}

void engineerOpt3(double radius, double direction, double &x, double &y){
    double PI = 3.14;
    double angle = direction * (PI/180);
    x = radius * cos(angle);
    y = radius * sin(angle);
}


//phase 2 option 1 subprograms

void phase2Opt1(){
    double radius1, direction1;
    double x1,y1, x2, y2, x, y, radius2, direction2, speed;
    double radius, direction, time;
    cout << "Enter coordinates for the first point (degree for direction):" << endl;
    polarCoordinates(radius1, direction1);
    cout << "Enter coordinates for the second point (degree for direction):" << endl;
    polarCoordinates(radius2, direction2);
    cout<<"Enter time between two objects (hours): ";
    cin>>time;
    while(time<0){
        cout<<"Enter a positive value for time: ";
        cin>>time;
    }

    //convert new pairs of x and y to polar coordinates
    phase2Engineer1(radius1, direction1, radius2, direction2, radius, direction);
    //finding speed
    speed = radius/time;

    //display result
    cout<<"You need to travel at "<< speed << " mile per hour in the direction of "<< direction << " degrees."<< endl;


}
void phase2Engineer1(double radius1, double direction1, double radius2, double direction2, double &radius, double &direction){
    double x1, y1, x2, y2;
    engineerOpt3(radius1, direction1, x1, y1);
    engineerOpt3(radius2, direction2, x2, y2);

    double x=x2 - x1; double y = y2 - y1;
    engineerOpt2(x, y, radius, direction);

}
//phase 2 options 2 subprograms
void phase2Opt2(){
    double radiusInitial, directionInitial;
    double directionHeading, speed, time;
    double radiusDestination, directionDestination;
    cout<<"Enter the initial location: "<<endl;
    polarCoordinates(radiusInitial, directionInitial);
    cout<<"Enter the direction you are heading (angle): ";
    cin>>directionHeading;
    while(directionHeading<-360 || directionHeading >360){
        cout<<"Please enter a value in a range of -360 to 360: ";
        cin>>directionHeading;
    }
    cout<<"Enter the speed (mile per hour): ";
    cin>>speed;
    while(speed<0){
        cout<<"Please enter a positive value for speed: ";
        cin>>speed;
    }
    cout<<"Enter time traveling (hours): ";
    cin>>time;
    while(time<0){
        cout<<"Enter a positive value for time: ";
        cin>>time;
    }
    phase2Engineer2(speed, time, directionHeading, radiusInitial, directionInitial, radiusDestination, directionDestination);
    cout<<"Final destination will be "<< radiusDestination << " mile(s) in the direction of "<< directionDestination<< endl;

}

void phase2Engineer2(double speed, double time, double directionHeading, double radiusInitial, double directionInitial, double &radiusDestination, double &directionDestination){
    //find distance
    double x1, y1, x2, y2;
    double distance = speed * time;
    engineerOpt3(distance, directionHeading, x1, y1);
    engineerOpt3(radiusInitial, directionInitial, x2, y2);
    double x =x1+x2;
    double y = y1+ y2;
    //change back to polar coordinate for final destination.
    engineerOpt2(x, y, radiusDestination, directionDestination);
}