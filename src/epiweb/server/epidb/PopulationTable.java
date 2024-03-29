package epiweb.server.epidb ;

import java.util.Map ;
import java.util.HashMap ;
import java.sql.Connection ;
import java.sql.SQLException ;
import com.javaranch.common.Str ;
import com.javaranch.db.DBResults ;
import com.javaranch.db.TableFacade ;

/** Strongly typed access to the database table "population".
 *
 * This source file was automatically generated by "Jenny the db code generator"
 * based on information found in the database.  Do not modify this file!
 *
 * For more information on Jenny, see http://www.javaranch.com/jenny.jsp
 *
 *
 * Most of the methods are static so you don't need to instantiate a copy of this class 
 * to do your work.  The primary access methods are:
 * <ul>
 *
 *     <b>getRow()/getRows()/getAllRows()</b><br>
 *     <b>search() </b><i>like getRows(), but you can specify which columns you want back</i><br>
 *     <b>update()</b><br>
 *     <b>delete()</b><br>
 *     <b>insert()</b><br>
 *
 * </ul>
 *
 * These methods all have the option of passing in a connection as the first parameter.
 * Usually you won't use a connection directly, but sometimes it's useful.
 *
 * The getRows() methods all return an array of Row objects or a single Row object.  The
 * row object is easy to work with and provides strong type checking.  If your table has
 * a lot of columns, and your search will return a lot of rows, you might want to consider
 * using a search() method instead.  You lose some of your strong type checking, but 
 * you might go a lot easier on memory.  In these cases, you will want to make sure you
 * use the column name constants found at the top of this class.
 *
 */
public class PopulationTable
{

    private static Implementation imp = new Implementation();

    public static final String tableName = "population";

    public static final String pmidColumnName = "pmid";
    public static final String yearColumnName = "year";
    public static final String populationColumnName = "population";
    public static final String other_populationColumnName = "other_population";
    public static final String age_stageColumnName = "age_stage";
    public static final String genderColumnName = "gender";
    public static final String nationalityColumnName = "nationality";
    public static final String ethnicityColumnName = "ethnicity";

    private static String[] allColumns =
    {
        pmidColumnName , yearColumnName , populationColumnName , other_populationColumnName , age_stageColumnName , genderColumnName , nationalityColumnName , ethnicityColumnName , 
    };

    /** You probably want to use the static methods for most of your access, but once in a while you might need to
     *  pass an instance object to a method that knows how to work with these sorts of tables.
     */
    public static Implementation getInstance()
    {
        return imp ;
    }

    /** For use by unit testing, although you could provide your own implementation here if
     *  you wanted to.
     *  
     *  To use this in your unit testing, create an instance of MockPopulationTable and pass
     *  it in here.  Then set your mock return values, call the method you are testing and examine
     *  the mock values that are now set!
     */
    public static void setInstance( PopulationTable.Implementation instance  )
    {
        imp = instance ;
    }

    /** Exposed for unit testing purposes only! */
    static class Implementation extends TableFacade
    {

        /** Exposed for unit testing purposes only! */
        Implementation()
        {
            super( EpidbFacade.getInstance() , tableName );
        }

        // convert a DBResults object to an array of Row objects.
        // requires that all of the columns be represented in the DBResults object and in the right order
        private static Row[] rowArray( DBResults r )
        {
            Row[] rows = new Row[ r.size() ];
            for( int i = 0 ; i < rows.length ; i++ )
            {
                rows[ i ] = new Row( r.getRow( i ) );
            }
            return rows ;
        }

        /** Instantiate an empty Row object */
        public Row getRow()
        {
            // if you are wondering about why this method is so lame - it's for unit testing!
            // The idea is that during unit testing, a different test object will be returned here.
            // To learn more about unit testing with Jenny generated code, visit <a href="http://www.javaranch.com/jenny.jsp">www.javaranch.com/jenny.jsp</a>
            return new Row();
        }

        /** Instantiate a Row object and fill its content based on a search
         *
         * Return null if not found.
         */
        public Row getRow( Connection con , String column , String searchText ) throws SQLException
        {
            Row row = new Row( this.search( con , column , searchText , allColumns ) );
            return row.dataLoadedFromDatabase() ? row : null ;
        }

        /** Instantiate a Row object and fill its content based on a search
         *
         * Return null if not found.
         */
        public Row getRow( String column , String searchText ) throws SQLException
        {
            Row row = new Row( this.search( column , searchText , allColumns ) );
            return row.dataLoadedFromDatabase() ? row : null ;
        }

        /** Return an array of length zero if nothing found */
        public Row[] getRows( Connection con , String column , String searchText ) throws SQLException
        {
            return rowArray( this.search( con , column , searchText , allColumns ) );
        }

        /** Return an array of length zero if nothing found */
        public Row[] getRows( String column , String searchText ) throws SQLException
        {
            return rowArray( this.search( column , searchText , allColumns ) );
        }

        /** Return an array of length zero if nothing found */
        public Row[] getRows( Connection con , String column , String[] searchText ) throws SQLException
        {
            return rowArray( this.search( con , column , searchText , allColumns ) );
        }

        /** Return an array of length zero if nothing found */
        public Row[] getRows( String column , String[] searchText ) throws SQLException
        {
            return rowArray( this.search( column , searchText , allColumns ) );
        }

        /** Return an array of length zero if nothing found */
        public Row[] getRows( Connection con , String whereClause ) throws SQLException
        {
            return rowArray( this.search( con , whereClause , allColumns ) );
        }

        /** Return an array of length zero if nothing found */
        public Row[] getRows( String whereClause ) throws SQLException
        {
            return rowArray( this.search( whereClause , allColumns ) );
        }

        /** Return an array of length zero if nothing found */
        public Row[] getAllRows( Connection con ) throws SQLException
        {
            return rowArray( this.search( con , allColumns ) );
        }

        /** Return an array of length zero if nothing found */
        public Row[] getAllRows() throws SQLException
        {
            return rowArray( this.search( allColumns ) );
        }


    }

    public static class Row
    {

        private boolean dataLoadedFromDatabase = false ;

        private int pmid ;
        private boolean pmidNull = true ;
        private int year ;
        private boolean yearNull = true ;
        private String population ;
        private String other_population ;
        private String age_stage ;
        private String gender ;
        private String nationality ;
        private String ethnicity ;

        /** for internal use only!   If you need a row object, use getRow(). */
        Row()
        {
        }

        private Row( String[] data )
        {
            if ( data != null )
            {
                this.pmidNull = ( data[0] == null );
                this.pmid = pmidNull ? 0 : Str.toInt( data[0] );
                this.yearNull = ( data[1] == null );
                this.year = yearNull ? 0 : Str.toInt( data[1] );
                this.population = data[2];
                this.other_population = data[3];
                this.age_stage = data[4];
                this.gender = data[5];
                this.nationality = data[6];
                this.ethnicity = data[7];
                dataLoadedFromDatabase = true ;
            }
        }

        private Row( DBResults results )
        {
            this( results.getRow(0) );
        }

        public int getPmid()
        {
            return pmid ;
        }

        public void setPmid( int pmid )
        {
            this.pmid = pmid ;
            pmidNull = false ;
        }

        public void setPmid( Integer pmid )
        {
            pmidNull = ( pmid == null );
            if ( pmidNull )
            {
                this.pmid = 0 ;
            }
            else
            {
                this.pmid = pmid.intValue() ;
            }
        }

        public boolean isPmidNull()
        {
            return pmidNull ;
        }

        public void setPmidNull( boolean pmidNull )
        {
            this.pmidNull = pmidNull ;
            if ( pmidNull )
            {
                pmid = 0 ;
            }
        }


        public int getYear()
        {
            return year ;
        }

        public void setYear( int year )
        {
            this.year = year ;
            yearNull = false ;
        }

        public void setYear( Integer year )
        {
            yearNull = ( year == null );
            if ( yearNull )
            {
                this.year = 0 ;
            }
            else
            {
                this.year = year.intValue() ;
            }
        }

        public boolean isYearNull()
        {
            return yearNull ;
        }

        public void setYearNull( boolean yearNull )
        {
            this.yearNull = yearNull ;
            if ( yearNull )
            {
                year = 0 ;
            }
        }


        public String getPopulation()
        {
            return population ;
        }

        public void setPopulation( String population )
        {
            this.population = population ;
        }


        public String getOther_population()
        {
            return other_population ;
        }

        public void setOther_population( String other_population )
        {
            this.other_population = other_population ;
        }


        public String getAge_stage()
        {
            return age_stage ;
        }

        public void setAge_stage( String age_stage )
        {
            this.age_stage = age_stage ;
        }


        public String getGender()
        {
            return gender ;
        }

        public void setGender( String gender )
        {
            this.gender = gender ;
        }


        public String getNationality()
        {
            return nationality ;
        }

        public void setNationality( String nationality )
        {
            this.nationality = nationality ;
        }


        public String getEthnicity()
        {
            return ethnicity ;
        }

        public void setEthnicity( String ethnicity )
        {
            this.ethnicity = ethnicity ;
        }



        
        private boolean dataLoadedFromDatabase()
        {
            return dataLoadedFromDatabase ;
        }

        private Map buildDataMap()
        {
            Map data = new HashMap();
            data.put( pmidColumnName , this.pmidNull ? null : String.valueOf( this.pmid ) );
            data.put( yearColumnName , this.yearNull ? null : String.valueOf( this.year ) );
            data.put( populationColumnName , this.population );
            data.put( other_populationColumnName , this.other_population );
            data.put( age_stageColumnName , this.age_stage );
            data.put( genderColumnName , this.gender );
            data.put( nationalityColumnName , this.nationality );
            data.put( ethnicityColumnName , this.ethnicity );
            return data ;
        }

        /** update a row object based on a search */
        public void update( Connection con , String column , String searchText ) throws SQLException
        {
            imp.update( con , column , searchText , buildDataMap() );
        }

        /** update a row object based on a search */
        public void update( String column , String searchText ) throws SQLException
        {
            imp.update( column , searchText , buildDataMap() );
        }

        /** create a new row.*/
        public void insert( Connection con ) throws SQLException
        {
            imp.insert( con , buildDataMap() );
        }

        /** create a new row.*/
        public void insert() throws SQLException
        {
            imp.insert( buildDataMap() );
        }


    }

    /** Return an empty row object */
    public static Row getRow()
    {
        return imp.getRow();
    }

    /** Instantiate a Row object and fill its content based on a search
     *
     * Return null if not found.
     */
    public static Row getRow( Connection con , String column , String searchText ) throws SQLException
    {
        return imp.getRow( con , column , searchText );
    }

    /** Instantiate a Row object and fill its content based on a search
     *
     * Return null if not found.
     */
    public static Row getRow( String column , String searchText ) throws SQLException
    {
        return imp.getRow( column , searchText );
    }

    /** Return an array of length zero if nothing found */
    public static Row[] getRows( Connection con , String column , String searchText ) throws SQLException
    {
        return imp.getRows( con , column , searchText );
    }

    /** Return an array of length zero if nothing found */
    public static Row[] getRows( String column , String searchText ) throws SQLException
    {
        return imp.getRows( column , searchText );
    }

    /** Return an array of length zero if nothing found */
    public static Row[] getRows( Connection con , String column , String[] searchText ) throws SQLException
    {
        return imp.getRows( con , column , searchText );
    }

    /** Return an array of length zero if nothing found */
    public static Row[] getRows( String column , String[] searchText ) throws SQLException
    {
        return imp.getRows( column , searchText );
    }

    /** Return an array of length zero if nothing found */
    public static Row[] getRows( Connection con , String column , int searchValue ) throws SQLException
    {
        return imp.getRows( con , column , String.valueOf( searchValue ) );
    }

    /** Return an array of length zero if nothing found */
    public static Row[] getRows( String column , int searchValue ) throws SQLException
    {
        return imp.getRows( column , String.valueOf( searchValue ) );
    }

    /** Return an array of length zero if nothing found */
    public static Row[] getRows( Connection con , String column , int[] searchValues ) throws SQLException
    {
        return imp.getRows( con , column , Str.toStringArray( searchValues ) );
    }

    /** Return an array of length zero if nothing found */
    public static Row[] getRows( String column , int[] searchValues ) throws SQLException
    {
        return imp.getRows( column , Str.toStringArray( searchValues ) );
    }

    /** Return an array of length zero if nothing found */
    public static Row[] getRows( Connection con , String whereClause ) throws SQLException
    {
        return imp.getRows( con , whereClause );
    }

    /** Return an array of length zero if nothing found */
    public static Row[] getRows( String whereClause ) throws SQLException
    {
        return imp.getRows( whereClause );
    }

    /** Return an array of length zero if nothing found */
    public static Row[] getAllRows( Connection con ) throws SQLException
    {
        return imp.getAllRows( con );
    }

    /** Return an array of length zero if nothing found */
    public static Row[] getAllRows() throws SQLException
    {
        return imp.getAllRows();
    }

    public static DBResults search( Connection con , String column , String searchText , String[] dataColumns ) throws SQLException
    {
        return imp.search( con , column , searchText , dataColumns );
    }

    public static DBResults search( String column , String searchText , String[] dataColumns ) throws SQLException
    {
        return imp.search( column , searchText , dataColumns );
    }

    public static DBResults search( Connection con , String column , String[] searchText , String[] dataColumns ) throws SQLException
    {
        return imp.search( con , column , searchText , dataColumns );
    }

    public static DBResults search( String column , String searchText[] , String[] dataColumns ) throws SQLException
    {
        return imp.search( column , searchText , dataColumns );
    }

    public static DBResults search( Connection con , String column , int searchValue , String[] dataColumns ) throws SQLException
    {
        return imp.search( con , column , searchValue , dataColumns );
    }

    public static DBResults search( String column , int searchValue , String[] dataColumns ) throws SQLException
    {
        return imp.search( column , searchValue , dataColumns );
    }

    public static DBResults search( Connection con , String column , int[] searchValues , String[] dataColumns ) throws SQLException
    {
        return imp.search( con , column , searchValues , dataColumns );
    }

    public static DBResults search( String column , int[] searchValues , String[] dataColumns ) throws SQLException
    {
        return imp.search( column , searchValues , dataColumns );
    }

    public static DBResults search( Connection con , String whereClause , String[] dataColumns ) throws SQLException
    {
        return imp.search( con , whereClause , dataColumns );
    }

    public static DBResults search( String whereClause , String[] dataColumns ) throws SQLException
    {
        return imp.search( whereClause , dataColumns );
    }

    public static DBResults search( Connection con , String[] dataColumns ) throws SQLException
    {
        return imp.search( con , dataColumns );
    }

    public static DBResults search( String[] dataColumns ) throws SQLException
    {
        return imp.search( dataColumns );
    }

    public static void update( Connection con , String column , String searchText , Map data ) throws SQLException
    {
        imp.update( con , column , searchText , data );
    }

    public static void update( String column , String searchText , Map data ) throws SQLException
    {
        imp.update( column , searchText , data );
    }

    public static void delete( Connection con , String column , String searchText ) throws SQLException
    {
        imp.delete( con , column , searchText );
    }

    public static void delete( String column , String searchText ) throws SQLException
    {
        imp.delete( column , searchText );
    }

    public static void insert( Connection con , Map data ) throws SQLException
    {
        imp.insert( con , data );
    }

    public static void insert( Map data ) throws SQLException
    {
        imp.insert( data );
    }



}
