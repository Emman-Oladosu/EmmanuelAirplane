import java.util.*;

public class Airplane {

	private Passenger passengers[];
	private String airplaneName;
	private int numPassengers;
	
	 public Airplane() {
	        passengers = new Passenger[100];
	        numPassengers = 0;
	    }
//-------
	    public Airplane(String airplaneName) {
	        this();
	        this.airplaneName = airplaneName;
	    }
//--
	    public Airplane(int maxPassengers) {
	        if (maxPassengers < 0) {
	            maxPassengers = 0;
	        }
	        passengers = new Passenger[maxPassengers];
	        numPassengers = 0;
	    }
	//------
	public Airplane(String airplaneName, int numPassengers){ 
		this.airplaneName = airplaneName;
		
		if(numPassengers < 0) {
			numPassengers = 0;
		}else {
		passengers = new Passenger[numPassengers];
		}
		
	}
	//-------
	public void resizePassengerArray() { 
		
		//THIS METHOD WORKS WITH addPassenger METHOD, BY MAKING A TEMPORARY ARRAY AND DOUBLING
		//THE LENGTH OF THE ORIGINAL ARRAY passengers
		
	  Passenger[] tempP = passengers;
	  
	  passengers = new Passenger[tempP.length * 2];
	  
	  for(int i = 0; i < tempP.length; i++){
		passengers[i] = tempP[i];  
	  }
		
	}
	//-----
	public void addPassenger(Passenger a) {
		
		//THIS METHOD FIRST CHECKS IF THERE IS ENOUGH SPACE TO ADD A PASSENGER INTO THE ARRAY 
		//passenger. IF THERE ISN'T ENOUGH SPACE, resizePassengerArray() WILL BE CALLED, USING THE TEMPORARY ARRAY WITH MORE SPACE
		// TO ADD A NEW PASSENGER
		 if (numPassengers < passengers.length) {
	            passengers[numPassengers] = a;
	            numPassengers++;
	        } else {
	        	resizePassengerArray();
	        	passengers[numPassengers++] = a;
	        }

	}
	//----------
	public String getAirplaneName() {
		return airplaneName;
	}
	//------
	public Passenger getPassenger(int i) {
		  
		if (i >= 0 && i < numPassengers) {
	            return passengers[i];
	        } else {
	            return null;
	        }
		
		
	}
	//-------
	public int getNumPassengers() {
		return numPassengers;
	}
	//-----------
	public Passenger getFirstPassenger() {
		return passengers[0];
	}
	//--------
	public Passenger getLastPassenger() {
		
//		for(int i = 0; i < passengers.length;i++) {
//			if(passengers[passengers.length -1 - i] != null) {
//				break;
//			}
//		}
		 return getPassenger(numPassengers - 1);
	}
	//---------
	public Passenger[] getPassengers() { //COME BACK TO THIS
		Passenger[] passengerList = new Passenger[numPassengers];
        for (int i = 0; i < numPassengers; i++) {
        	passengerList[i] = passengers[i];
        }
        return passengerList;
	}
	//-------
	public void setAirplaneName(String airplaneName) {
		this.airplaneName = airplaneName;
	}
	//--------
	public void printAllDetails() {
        System.out.printf("AirplaneName: %20s | Number of Passengers: %4d | Airplane Size: %4d\n",airplaneName, numPassengers, passengers.length);
        for (int i = 0; i < numPassengers; i++) {
            passengers[i].printDetails();
        }
    }
	//----
	
	  public Passenger removePassenger(int index) {
	        if (index >= 0 && index < numPassengers) {
	            Passenger result = passengers[index];
	            for (int i = index; i < numPassengers - 1; i++) {
	                passengers[i] = passengers[i + 1];
	            }
	            passengers[numPassengers - 1] = null;
	            numPassengers--;
	            return result;
	        } else {
	            return null;
	        }
	    }
	//---
//	public double getTotalWeightOfAllPassengers() {//FIX THIS METHOD
//		double totalWeight = 0.0;
//		
//		for(int i = 0; i < passengers.length; i++) {
//			totalWeight += getWeight();
//		}
//		
//		return totalWeight;
	//}
	//-------
//	public void increaseWeightOfAllPassengers() { //FIX THIS METHOD
//		for(int i = 0; i < passengers.length; i++) {
//			gainWeight();
//		}
//	}
	//------
	
}
