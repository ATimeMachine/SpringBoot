package com.example.security.dao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
*
*  @author persistentLogins
*/
public class PersistentLogins implements Serializable {

    private static final long serialVersionUID = 1577521829584L;


    /**
    * 
    * isNullAble:0
    */
    private String username;

    /**
    * 主键
    * 
    * isNullAble:0
    */
    private String series;

    /**
    * 
    * isNullAble:0
    */
    private String token;

    /**
    * 
    * isNullAble:0,defaultVal:CURRENT_TIMESTAMP
    */
    private java.time.LocalDateTime lastUsed;


    public void setUsername(String username){this.username = username;}

    public String getUsername(){return this.username;}

    public void setSeries(String series){this.series = series;}

    public String getSeries(){return this.series;}

    public void setToken(String token){this.token = token;}

    public String getToken(){return this.token;}

    public void setLastUsed(java.time.LocalDateTime lastUsed){this.lastUsed = lastUsed;}

    public java.time.LocalDateTime getLastUsed(){return this.lastUsed;}
    @Override
    public String toString() {
        return "PersistentLogins{" +
                "username='" + username + '\'' +
                "series='" + series + '\'' +
                "token='" + token + '\'' +
                "lastUsed='" + lastUsed + '\'' +
            '}';
    }

    public static Builder Build(){return new Builder();}

    public static ConditionBuilder ConditionBuild(){return new ConditionBuilder();}

    public static UpdateBuilder UpdateBuild(){return new UpdateBuilder();}

    public static QueryBuilder QueryBuild(){return new QueryBuilder();}

    public static class UpdateBuilder {

        private PersistentLogins set;

        private ConditionBuilder where;

        public UpdateBuilder set(PersistentLogins set){
            this.set = set;
            return this;
        }

        public PersistentLogins getSet(){
            return this.set;
        }

        public UpdateBuilder where(ConditionBuilder where){
            this.where = where;
            return this;
        }

        public ConditionBuilder getWhere(){
            return this.where;
        }

        public UpdateBuilder build(){
            return this;
        }
    }

    public static class QueryBuilder extends PersistentLogins{
        /**
        * 需要返回的列
        */
        private Map<String,Object> fetchFields;

        public Map<String,Object> getFetchFields(){return this.fetchFields;}

        private List<String> usernameList;

        public List<String> getUsernameList(){return this.usernameList;}


        private List<String> fuzzyUsername;

        public List<String> getFuzzyUsername(){return this.fuzzyUsername;}

        private List<String> rightFuzzyUsername;

        public List<String> getRightFuzzyUsername(){return this.rightFuzzyUsername;}
        private List<String> seriesList;

        public List<String> getSeriesList(){return this.seriesList;}


        private List<String> fuzzySeries;

        public List<String> getFuzzySeries(){return this.fuzzySeries;}

        private List<String> rightFuzzySeries;

        public List<String> getRightFuzzySeries(){return this.rightFuzzySeries;}
        private List<String> tokenList;

        public List<String> getTokenList(){return this.tokenList;}


        private List<String> fuzzyToken;

        public List<String> getFuzzyToken(){return this.fuzzyToken;}

        private List<String> rightFuzzyToken;

        public List<String> getRightFuzzyToken(){return this.rightFuzzyToken;}
        private List<java.time.LocalDateTime> lastUsedList;

        public List<java.time.LocalDateTime> getLastUsedList(){return this.lastUsedList;}

        private java.time.LocalDateTime lastUsedSt;

        private java.time.LocalDateTime lastUsedEd;

        public java.time.LocalDateTime getLastUsedSt(){return this.lastUsedSt;}

        public java.time.LocalDateTime getLastUsedEd(){return this.lastUsedEd;}

        private QueryBuilder (){
            this.fetchFields = new HashMap<>();
        }

        public QueryBuilder fuzzyUsername (List<String> fuzzyUsername){
            this.fuzzyUsername = fuzzyUsername;
            return this;
        }

        public QueryBuilder fuzzyUsername (String ... fuzzyUsername){
            this.fuzzyUsername = solveNullList(fuzzyUsername);
            return this;
        }

        public QueryBuilder rightFuzzyUsername (List<String> rightFuzzyUsername){
            this.rightFuzzyUsername = rightFuzzyUsername;
            return this;
        }

        public QueryBuilder rightFuzzyUsername (String ... rightFuzzyUsername){
            this.rightFuzzyUsername = solveNullList(rightFuzzyUsername);
            return this;
        }

        public QueryBuilder username(String username){
            setUsername(username);
            return this;
        }

        public QueryBuilder usernameList(String ... username){
            this.usernameList = solveNullList(username);
            return this;
        }

        public QueryBuilder usernameList(List<String> username){
            this.usernameList = username;
            return this;
        }

        public QueryBuilder fetchUsername(){
            setFetchFields("fetchFields","username");
            return this;
        }

        public QueryBuilder excludeUsername(){
            setFetchFields("excludeFields","username");
            return this;
        }

        public QueryBuilder fuzzySeries (List<String> fuzzySeries){
            this.fuzzySeries = fuzzySeries;
            return this;
        }

        public QueryBuilder fuzzySeries (String ... fuzzySeries){
            this.fuzzySeries = solveNullList(fuzzySeries);
            return this;
        }

        public QueryBuilder rightFuzzySeries (List<String> rightFuzzySeries){
            this.rightFuzzySeries = rightFuzzySeries;
            return this;
        }

        public QueryBuilder rightFuzzySeries (String ... rightFuzzySeries){
            this.rightFuzzySeries = solveNullList(rightFuzzySeries);
            return this;
        }

        public QueryBuilder series(String series){
            setSeries(series);
            return this;
        }

        public QueryBuilder seriesList(String ... series){
            this.seriesList = solveNullList(series);
            return this;
        }

        public QueryBuilder seriesList(List<String> series){
            this.seriesList = series;
            return this;
        }

        public QueryBuilder fetchSeries(){
            setFetchFields("fetchFields","series");
            return this;
        }

        public QueryBuilder excludeSeries(){
            setFetchFields("excludeFields","series");
            return this;
        }

        public QueryBuilder fuzzyToken (List<String> fuzzyToken){
            this.fuzzyToken = fuzzyToken;
            return this;
        }

        public QueryBuilder fuzzyToken (String ... fuzzyToken){
            this.fuzzyToken = solveNullList(fuzzyToken);
            return this;
        }

        public QueryBuilder rightFuzzyToken (List<String> rightFuzzyToken){
            this.rightFuzzyToken = rightFuzzyToken;
            return this;
        }

        public QueryBuilder rightFuzzyToken (String ... rightFuzzyToken){
            this.rightFuzzyToken = solveNullList(rightFuzzyToken);
            return this;
        }

        public QueryBuilder token(String token){
            setToken(token);
            return this;
        }

        public QueryBuilder tokenList(String ... token){
            this.tokenList = solveNullList(token);
            return this;
        }

        public QueryBuilder tokenList(List<String> token){
            this.tokenList = token;
            return this;
        }

        public QueryBuilder fetchToken(){
            setFetchFields("fetchFields","token");
            return this;
        }

        public QueryBuilder excludeToken(){
            setFetchFields("excludeFields","token");
            return this;
        }

        public QueryBuilder lastUsedBetWeen(java.time.LocalDateTime lastUsedSt,java.time.LocalDateTime lastUsedEd){
            this.lastUsedSt = lastUsedSt;
            this.lastUsedEd = lastUsedEd;
            return this;
        }

        public QueryBuilder lastUsedGreaterEqThan(java.time.LocalDateTime lastUsedSt){
            this.lastUsedSt = lastUsedSt;
            return this;
        }
        public QueryBuilder lastUsedLessEqThan(java.time.LocalDateTime lastUsedEd){
            this.lastUsedEd = lastUsedEd;
            return this;
        }


        public QueryBuilder lastUsed(java.time.LocalDateTime lastUsed){
            setLastUsed(lastUsed);
            return this;
        }

        public QueryBuilder lastUsedList(java.time.LocalDateTime ... lastUsed){
            this.lastUsedList = solveNullList(lastUsed);
            return this;
        }

        public QueryBuilder lastUsedList(List<java.time.LocalDateTime> lastUsed){
            this.lastUsedList = lastUsed;
            return this;
        }

        public QueryBuilder fetchLastUsed(){
            setFetchFields("fetchFields","lastUsed");
            return this;
        }

        public QueryBuilder excludeLastUsed(){
            setFetchFields("excludeFields","lastUsed");
            return this;
        }
        private <T>List<T> solveNullList(T ... objs){
            if (objs != null){
            List<T> list = new ArrayList<>();
                for (T item : objs){
                    if (item != null){
                        list.add(item);
                    }
                }
                return list;
            }
            return null;
        }

        public QueryBuilder fetchAll(){
            this.fetchFields.put("AllFields",true);
            return this;
        }

        public QueryBuilder addField(String ... fields){
            List<String> list = new ArrayList<>();
            if (fields != null){
                for (String field : fields){
                    list.add(field);
                }
            }
            this.fetchFields.put("otherFields",list);
            return this;
        }
        @SuppressWarnings("unchecked")
        private void setFetchFields(String key,String val){
            Map<String,Boolean> fields= (Map<String, Boolean>) this.fetchFields.get(key);
            if (fields == null){
                fields = new HashMap<>();
            }
            fields.put(val,true);
            this.fetchFields.put(key,fields);
        }

        public PersistentLogins build(){return this;}
    }


    public static class ConditionBuilder{
        private List<String> usernameList;

        public List<String> getUsernameList(){return this.usernameList;}


        private List<String> fuzzyUsername;

        public List<String> getFuzzyUsername(){return this.fuzzyUsername;}

        private List<String> rightFuzzyUsername;

        public List<String> getRightFuzzyUsername(){return this.rightFuzzyUsername;}
        private List<String> seriesList;

        public List<String> getSeriesList(){return this.seriesList;}


        private List<String> fuzzySeries;

        public List<String> getFuzzySeries(){return this.fuzzySeries;}

        private List<String> rightFuzzySeries;

        public List<String> getRightFuzzySeries(){return this.rightFuzzySeries;}
        private List<String> tokenList;

        public List<String> getTokenList(){return this.tokenList;}


        private List<String> fuzzyToken;

        public List<String> getFuzzyToken(){return this.fuzzyToken;}

        private List<String> rightFuzzyToken;

        public List<String> getRightFuzzyToken(){return this.rightFuzzyToken;}
        private List<java.time.LocalDateTime> lastUsedList;

        public List<java.time.LocalDateTime> getLastUsedList(){return this.lastUsedList;}

        private java.time.LocalDateTime lastUsedSt;

        private java.time.LocalDateTime lastUsedEd;

        public java.time.LocalDateTime getLastUsedSt(){return this.lastUsedSt;}

        public java.time.LocalDateTime getLastUsedEd(){return this.lastUsedEd;}


        public ConditionBuilder fuzzyUsername (List<String> fuzzyUsername){
            this.fuzzyUsername = fuzzyUsername;
            return this;
        }

        public ConditionBuilder fuzzyUsername (String ... fuzzyUsername){
            this.fuzzyUsername = solveNullList(fuzzyUsername);
            return this;
        }

        public ConditionBuilder rightFuzzyUsername (List<String> rightFuzzyUsername){
            this.rightFuzzyUsername = rightFuzzyUsername;
            return this;
        }

        public ConditionBuilder rightFuzzyUsername (String ... rightFuzzyUsername){
            this.rightFuzzyUsername = solveNullList(rightFuzzyUsername);
            return this;
        }

        public ConditionBuilder usernameList(String ... username){
            this.usernameList = solveNullList(username);
            return this;
        }

        public ConditionBuilder usernameList(List<String> username){
            this.usernameList = username;
            return this;
        }

        public ConditionBuilder fuzzySeries (List<String> fuzzySeries){
            this.fuzzySeries = fuzzySeries;
            return this;
        }

        public ConditionBuilder fuzzySeries (String ... fuzzySeries){
            this.fuzzySeries = solveNullList(fuzzySeries);
            return this;
        }

        public ConditionBuilder rightFuzzySeries (List<String> rightFuzzySeries){
            this.rightFuzzySeries = rightFuzzySeries;
            return this;
        }

        public ConditionBuilder rightFuzzySeries (String ... rightFuzzySeries){
            this.rightFuzzySeries = solveNullList(rightFuzzySeries);
            return this;
        }

        public ConditionBuilder seriesList(String ... series){
            this.seriesList = solveNullList(series);
            return this;
        }

        public ConditionBuilder seriesList(List<String> series){
            this.seriesList = series;
            return this;
        }

        public ConditionBuilder fuzzyToken (List<String> fuzzyToken){
            this.fuzzyToken = fuzzyToken;
            return this;
        }

        public ConditionBuilder fuzzyToken (String ... fuzzyToken){
            this.fuzzyToken = solveNullList(fuzzyToken);
            return this;
        }

        public ConditionBuilder rightFuzzyToken (List<String> rightFuzzyToken){
            this.rightFuzzyToken = rightFuzzyToken;
            return this;
        }

        public ConditionBuilder rightFuzzyToken (String ... rightFuzzyToken){
            this.rightFuzzyToken = solveNullList(rightFuzzyToken);
            return this;
        }

        public ConditionBuilder tokenList(String ... token){
            this.tokenList = solveNullList(token);
            return this;
        }

        public ConditionBuilder tokenList(List<String> token){
            this.tokenList = token;
            return this;
        }

        public ConditionBuilder lastUsedBetWeen(java.time.LocalDateTime lastUsedSt,java.time.LocalDateTime lastUsedEd){
            this.lastUsedSt = lastUsedSt;
            this.lastUsedEd = lastUsedEd;
            return this;
        }

        public ConditionBuilder lastUsedGreaterEqThan(java.time.LocalDateTime lastUsedSt){
            this.lastUsedSt = lastUsedSt;
            return this;
        }
        public ConditionBuilder lastUsedLessEqThan(java.time.LocalDateTime lastUsedEd){
            this.lastUsedEd = lastUsedEd;
            return this;
        }


        public ConditionBuilder lastUsedList(java.time.LocalDateTime ... lastUsed){
            this.lastUsedList = solveNullList(lastUsed);
            return this;
        }

        public ConditionBuilder lastUsedList(List<java.time.LocalDateTime> lastUsed){
            this.lastUsedList = lastUsed;
            return this;
        }

        private <T>List<T> solveNullList(T ... objs){
            if (objs != null){
            List<T> list = new ArrayList<>();
                for (T item : objs){
                    if (item != null){
                        list.add(item);
                    }
                }
                return list;
            }
            return null;
        }

        public ConditionBuilder build(){return this;}
    }

    public static class Builder {

        private PersistentLogins obj;

        public Builder(){
            this.obj = new PersistentLogins();
        }

        public Builder username(String username){
            this.obj.setUsername(username);
            return this;
        }
        public Builder series(String series){
            this.obj.setSeries(series);
            return this;
        }
        public Builder token(String token){
            this.obj.setToken(token);
            return this;
        }
        public Builder lastUsed(java.time.LocalDateTime lastUsed){
            this.obj.setLastUsed(lastUsed);
            return this;
        }
        public PersistentLogins build(){return obj;}
    }

}
