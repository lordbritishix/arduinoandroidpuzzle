/*
  DigitalReadSerial
 Reads a digital input on pin 2, prints the result to the serial monitor 
 
 This example code is in the public domain.
 */

// digital pin 2 has a pushbutton attached to it. Give it a name:

//PIN2
int PUSH_BUTTON2 = 2;
int LED_PIN2 = 13;

//PIN3
int PUSH_BUTTON3 = 4;
int LED_PIN3 = 12;

//PIN3
int PUSH_BUTTON4 = 7;
int LED_PIN4 = 8;

//PIN4
int PUSH_BUTTON5 = 6;


boolean pushButton2LastState = false;
boolean pin2LedState = false;

boolean pushButton3LastState = false;
boolean pin3LedState = false;

boolean pushButton4LastState = false;
boolean pin4LedState = false;

boolean pushButton5LastState = false;


// the setup routine runs once when you press reset:
void setup() {
  // initialize serial communication at 9600 bits per second:
  Serial.begin(9600);
  // make the pushbutton's pin an input:
  pinMode(PUSH_BUTTON2, INPUT);
  pinMode(LED_PIN2, OUTPUT);
  
  pinMode(PUSH_BUTTON3, INPUT);
  pinMode(LED_PIN3, OUTPUT);
  
  pinMode(PUSH_BUTTON4, INPUT);
  pinMode(LED_PIN4, OUTPUT);

  pinMode(PUSH_BUTTON5, INPUT);

}

// the loop routine runs over and over again forever:
void loop() {
  // read the input pin:
    
  handlePinAndWriteMessage(digitalRead(PUSH_BUTTON2), LED_PIN2); 
  handlePin2AndWriteMessage(digitalRead(PUSH_BUTTON3), LED_PIN3); 
  handlePin3AndWriteMessage(digitalRead(PUSH_BUTTON4), LED_PIN4); 
  handlePin4AndWriteMessage(digitalRead(PUSH_BUTTON5));
  

  delay(1);        // delay in between reads for stability
}

void handlePinAndWriteMessage(int button, int led) {
  if ((button) && !pushButton2LastState) {
    pushButton2LastState = true;
  } 
  
  if (!button && pushButton2LastState) {
    Serial.println("pin2:true");    
    pushButton2LastState = false;     
    pin2LedState = !pin2LedState;
  }
  
  if (pin2LedState) {
    digitalWrite(led, HIGH);        
  }
  else {
    digitalWrite(led, LOW);  
  }  
}

void handlePin2AndWriteMessage(int button, int led) {
  if ((button) && !pushButton3LastState) {
    pushButton3LastState = true;
  } 
  
  if (!button && pushButton3LastState) {
    Serial.println("pin3:true");    
    pushButton3LastState = false;     
    pin3LedState = !pin3LedState;
  }
  
  if (pin3LedState) {
    digitalWrite(led, HIGH);        
  }
  else {
    digitalWrite(led, LOW);  
  }  
}

void handlePin3AndWriteMessage(int button, int led) {
  if ((button) && !pushButton4LastState) {
    pushButton4LastState = true;
  } 
  
  if (!button && pushButton4LastState) {
    Serial.println("pin4:true");    
    pushButton4LastState = false;     
    pin4LedState = !pin4LedState;
  }
  
  if (pin4LedState) {
    digitalWrite(led, HIGH);        
  }
  else {
    digitalWrite(led, LOW);  
  }  
}

void handlePin4AndWriteMessage(int button) {
  if ((button) && !pushButton5LastState) {
    pushButton5LastState = true;
  } 
  
  if (!button && pushButton5LastState) {
    Serial.println("confirm");    
    pushButton5LastState = false;     
  }  
}







