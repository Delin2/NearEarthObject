/**
* Dennis Lin
* 109426873
* Homework #7
* CSE214 R05 
* Recitation TA: Vladimir Yevseenko
* Grading TA: Xi Zhang
 */

import java.util.Date;

public class NearEarthObject {
    private int referenceID;
    private String name;
    private double absoluteMagnitude;
    private double averageDiameter;
    private boolean isDangerous;
    private long closestApproachDate;
    private double missDistance;
    private String orbitingBody;
    
    /**
     * Default Constructor.
     *   Note: It is very important that your constructor exactly match this signature. This constructor will be used by the BigData library to fetch the NearEarthObject records from the NeoW API.
     *   Parameters:
     *      @param referenceID - Unique the ID of the NEO.
     *          Fetched using the "near_earth_objects/neo_reference_id" identifier.
     *      @param name - Unique name of the asteroid or orbital body.
     *          Fetched using the "near_earth_objects/name" identifier.
     *      @param absoluteMagnitude - Absolute brightness of the asteroid or orbital body in the sky.
     *          Fetched using the "near_earth_objects/absolute_magnitude_h" identifier.
     *      @param minDiameter - Estimated minimum diameter of the asteroid or orbital body in kilometers. This parameter should be used in conjunction with the maxDiameter parameter to calculate and initialize the averageDiameter member variable.
     *          Fetched using the "near_earth_objects/estimated_diameter/kilometers/estimated_diameter_min" identifier.
     *      @param maxDiameter - Estimated maximum diameter of the asteroid or orbital body in kilometers. This parameter should be used in conjunction with the minDiameter parameter to calculate and initialize the averageDiameter member variable.
     *          Fetched using the "near_earth_objects/estimated_diameter/kilometers/estimated_diameter_max" identifier.
     *      @param isDangerous - Boolean value indicating whether the astroid or orbital body is a potential impact threat.
     *          Fetched using the "near_earth_objects/is_potentially_hazardous_asteroid" identifier.
     *      @param closestDateTimestamp - Unix timestamp representing the date of closest approach. Note that this can be used to directly construct the closestApproachDate member variable, as the Date class provides a constructor taking a timestamp as a parameter.
     *          Fetched using the "near_earth_objects/close_approach_data/epoch_date_close_approach" identifier.
     *      @param missDistance - Distance in kilometers at which the asteroid or orbital body will pass by the Earth on the date of it's closest approach.
     *          Fetched using the "near_earth_objects/close_approach_data/miss_distance/kilometers" identifier.
     *      @param orbitingBody - Planet or other orbital body which this NEO orbits.
     *          Fetched using the "near_earth_objects/close_approach_data/orbiting_body" identifier.
     */
    public NearEarthObject(int referenceID, String name, double absoluteMagnitude, double minDiameter, double maxDiameter, boolean isDangerous, long closestDateTimestamp, double missDistance, String orbitingBody){
        this.referenceID = referenceID;
        this.name = name;
        this.absoluteMagnitude = absoluteMagnitude;
        this.averageDiameter = ((minDiameter + maxDiameter)/2);
        this.isDangerous = isDangerous;
        this.missDistance = missDistance;
        this.closestApproachDate = closestDateTimestamp;
        this.orbitingBody = orbitingBody;
    }
    
    /**
     * Getter for referenceID
     * @return referenceID
     */
    public int getReferenceID(){
        return referenceID;
    }
    
    /**
     * Setter for referenceID
     * @param id 
     */
    public void setReferenceID(int id){
        this.referenceID = id;
    }
    
    /**
     * Getter for name
     * @return name
     */
    public String getName(){
        return name;
    }
    
    /**
     * Setter for name
     * @param name 
     */
    public void setName(String name){
        this.name = name;
    }
    
    /**
     * Getter for absoluteMagnitude
     * @return absoluteMagnitude
     */    
    public double getAbsoluteMagnitude(){
        return this.absoluteMagnitude;
    }
    
    /**
     * Setter for absoluteMagnitude
     * @param absoluteMagnitude 
     */
    public void setAbsoluteMagnitude(double absoluteMagnitude){
        this.absoluteMagnitude = absoluteMagnitude;
    }
    
    /**
     * Getter for averageDiameter
     * @return averageDiameter
     */
    public double getAverageDiameter(){
        return this.averageDiameter;
    }
    
    /**
     * Setter for averageDiameter
     * @param averageDiameter 
     */
    public void setAverageDiameter(double averageDiameter){
        this.averageDiameter = averageDiameter;
    }
    
    /**
     * Getter for isDangerous
     * @return isDangerous
     */
    public boolean getIsDangerous(){
        return this.isDangerous;
    }
    
    /**
     * Setter for isDangerous
     * @param isDangerous 
     */
    public void setIsDangerous(boolean isDangerous){
        this.isDangerous = isDangerous;
    }
    
    /**
     * Getter for closestApproachDate
     * @return closestApproachDate
     */
    public long getClosestApproachDate(){
        return this.closestApproachDate;
    }
    
    /**
     * Setter for closestApproachDate
     * @param closestApproachDate 
     */
    public void setClosestApproachDate(long closestApproachDate){
        this.closestApproachDate = closestApproachDate;
    }
    
    /**
     * Getter for missDistance
     * @return missDistance
     */
    public double getMissDistance(){
        return this.missDistance;
    }
    
    /**
     * Setter for missDistance
     * @param missDistance 
     */
    public void setMissDistance(double missDistance){
        this.missDistance = missDistance;
    }
    
    /**
     * Getter for OrbitingBody
     * @return orbitingBody
     */
    public String getOrbitingBody(){
        return this.orbitingBody;
    }
    
    /**
     * Setter for orbitingBody
     * @param orbitingBody 
     */
    public void setOrbitingBody(String orbitingBody){
        this.orbitingBody = orbitingBody;
    }
    
    @Override
    public String toString() { 
        Date date = new Date(closestApproachDate);
            return String.format("%-11d%-14s%-8.1f%-10.3f%-10b%-13tD%-12.0f%-10s", referenceID, name, absoluteMagnitude, averageDiameter, isDangerous, date, missDistance, orbitingBody);
        }
}
