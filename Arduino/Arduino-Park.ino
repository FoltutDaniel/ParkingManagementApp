#include <Servo.h> 

Servo servo_test;
int angle = 0;

int redPin = 9;
int greenPin = 10;
int bluePin = 11;

int trigPin = 2;
int echoPin = 3;

float duration;
float distance;

int incomingByte;

void setup() {
  // put your setup code here, to run once:
  pinMode(redPin, OUTPUT);
  pinMode(greenPin, OUTPUT);
  pinMode(bluePin, OUTPUT);
  servo_test.attach(8);
  servo_test.write(0);
  
  Serial.begin(9600);
  pinMode(trigPin, OUTPUT);
  pinMode(echoPin, INPUT);
}

void loop() {
  // put your main code here, to run repeatedly:

  digitalWrite(trigPin, LOW);
  delayMicroseconds(2);
  digitalWrite(trigPin, HIGH);
  delayMicroseconds(10);
  digitalWrite(trigPin, LOW);

  duration = pulseIn(echoPin, HIGH);

  distance = (duration / 2) * 0.0343;

  Serial.println(distance);

  if(Serial.available() > 0){
    incomingByte = Serial.read();
    if(incomingByte == 'H'){
      setColor(255,0,0);
      delay(5000);
    }
    if(incomingByte == 'L'){
      setColor(0,255,0);

      for(angle = 0; angle < 90; angle = angle + 5){
          servo_test.write(angle);
          delay(15);
       }
  
       delay(50000);
  
      for(angle = 90; angle >=1; angle = angle-5){
        servo_test.write(angle);
        delay(15);
      }
      delay(10000);
    }
  }
  delay(1000);

}

void setColor(int redValue, int greenValue, int blueValue) {
  analogWrite(redPin, redValue);
  analogWrite(greenPin, greenValue);
  analogWrite(bluePin, blueValue);
}
