long startTime = System.nanoTime();
methodToTime(); 
long endTime = System.nanoTime();
//The result will be in Nanoseconds, divide it by 1000000 to get it in Milliseconds.
long timeElapsed = (endTime - startTime);  
