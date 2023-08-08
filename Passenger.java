
public abstract class Passenger implements Eater{

	private String name;
	private int birthYear;
	private double weight;
	private char gender;
	private int numCarryOn;
	private double height;
	private int caloriesConsumed;
	private int caloriesAccumulator = 0;

	
	public Passenger() {
		name = "";
		birthYear = 1900;
		weight = 0.0;
		gender = 'u';
		numCarryOn = 0;
		height = 0.0;
		caloriesConsumed = 0;
        caloriesAccumulator += caloriesConsumed;
	}
	
	
	 public Passenger(String name, int birthYear, double weight, double height, char gender, int numCarryOn, int caloriesConsumed, int aloriesAccumulator) {
		 this.name = name;
	        this.birthYear = birthYear;
	        
	        if (weight < 0) {
	            this.weight = -1.0;
	        } else {
	            this.weight = weight;
	        }
	        
	        if(height < 0.0) {
				this.height = -1.0;
			}else {
				this.height = height;
			}
	        if((gender == 'm') || (gender == 'f')) {
				this.gender = gender;
			}
			else {
				this.gender = 'u';
			}
	        
	        if (this.numCarryOn < 0) {
	            this.numCarryOn = 0;
	        } else if (numCarryOn > 2) {
	            this.numCarryOn = 2;
	        } else {
	            this.numCarryOn = numCarryOn;
	        }
	        
	        this.caloriesConsumed = caloriesConsumed;
	        this.caloriesAccumulator += caloriesConsumed;
	        
	    }
	
	public int calculateAge(int currentYear) {
		int age;
		
		age = currentYear - birthYear;
		
		if(currentYear < birthYear) {
			age = -1;
		}
		
		return age;
	}
	
	public int getCaloriesConsumed() {
        return caloriesConsumed;
    }

    public void setCaloriesConsumed(int caloriesConsumed) {
        this.caloriesConsumed = caloriesConsumed;
    }

    public int getCaloriesAccumulator() {
        return caloriesAccumulator;
    }

    public void setCaloriesAccumulator(int caloriesAccumulator) {
        this.caloriesAccumulator = caloriesAccumulator;
    }
	
	public void gainWeight() {
		if (this.weight + 1.0 < 0.0) {
            this.weight = 0.0;
        }else {
		weight++;
        }
		
	}
	
	public void gainWeight(double weight) {
		 	
		if (this.weight + weight < 0.0) {
            this.weight = 0.0;
        }
        else {
            this.weight = this.weight + weight;
        }
		
	}

	public int getBirthYear() {
		return birthYear;
	}
	
	public char getGender() {
		return gender;
	}
	
	public String getName() {
		return name;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public int getNumCarryOn() {
		return numCarryOn;
	}
	
	
	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		if(height < 0.0) {
			this.height = -1.0;
		}else {
			this.height = height;
		}
	}

	public boolean isFemale() {
		boolean female = false;
		if(gender == 'f') {
			female = true;
			return female;
		}
		else {
			return female;
		}
	}
	
	public boolean isMale() {
		boolean male = false;
		if(gender == 'm') {
			male = true;
			return male;
		}
		else {
			return male;
		}
		
	}	
	
	public void loseWeight() {
		weight--;
		if(weight < 0.0) {
			weight = 0.0;
		}
	}
	
	public void loseWeight(double weight) {
		
		if(this.weight - weight < 0.0) {
			weight = 0.0;
		}
		else {
			this.weight -= weight;
		}
		
	}
	
	
	//-----
	
	public void setGender(char gender) {
		
		if((gender == 'm') || (gender == 'f')) {
			this.gender = gender;
		}
		else {
			this.gender = 'u';
		}
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}
	
	public void setWeight(double weight) {
		
        if (weight < 0) {
            this.weight = -1.0;
        } else {
            this.weight = weight;
        }
    }
	
	
	public void setNumCarryOn(int numCarryOn) {
        if (numCarryOn < 0) {
            this.numCarryOn = 0;
        } else if (numCarryOn > 2) {
            this.numCarryOn = 2;
        } else {
            this.numCarryOn = numCarryOn;
        }
    }
	
	public double calculateBMI() {
		double BMI = ( weight * 703) / Math.pow(height, 2.0); 
		
		return BMI;
	}
	
	 public void printDetails() {
	        System.out.printf("Name: %20s | Year of Birth: %4d | Weight: %10.2f | Gender: %c | NumCarryOn: %2d\n",name, birthYear, weight, gender, numCarryOn);
	    }

	@Override
	public String toString() {
		return String.format("Name: %20s | Year of Birth: %4d | Weight: %10.2f | Height: %10.2f | Gender: %c | NumCarryOn: %2d\n",name,birthYear,weight,height,gender,numCarryOn);
	}

	public boolean equals(Object o){
		if(o==null){return false;}
		if(this == o){return true;}
		if(o instanceof Passenger){
			Passenger otherP = (Passenger)o;
			   if(this.name.equalsIgnoreCase(otherP.name)){
				   if(this.birthYear == otherP.birthYear) {
	                 if(this.gender == otherP.gender) {
	                	 if(Math.abs(this.weight - otherP.weight) <= 0.5) {
	                		if(Math.abs(this.height - otherP.height) <= 0.5) {
	                			return true;
	                		}
	                	 }
	                 }
				   }
			   }
		}
		return false;
	}
	
	public abstract double metabolizeAccumulatedCalories();


	@Override
	public void eat(Food food) {
		// TODO Auto-generated method stub
		caloriesConsumed += food.getCalories();
        caloriesAccumulator += food.getCalories();
	}


	@Override
	public void eat(Food[] foods) {
		// TODO Auto-generated method stub
		for (Food food : foods) {
            caloriesConsumed += food.getCalories();
            caloriesAccumulator += food.getCalories();
        }
	}
	
}
