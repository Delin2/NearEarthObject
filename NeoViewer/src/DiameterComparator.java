/**
* Dennis Lin
* 109426873
* Homework #7
* CSE214 R05 
* Recitation TA: Vladimir Yevseenko
* Grading TA: Xi Zhang
*/

public class DiameterComparator implements java.util.Comparator<NearEarthObject>{

    @Override
    public int compare(NearEarthObject o1, NearEarthObject o2) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    if(o1.getAverageDiameter() == o2.getAverageDiameter())
        return 0;
    else if(o1.getAverageDiameter()> o2.getAverageDiameter())
        return 1;
    else
        return -1;
    }
    
}
