package com.eaglesakura

import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import java.util.HashMap

 class GeneratedFirebaseConfig {
    
    FirebaseRemoteConfig mRemoteConfig
    
     static final String ID_STRING_VALUE = "string_value"
     static final String ID_DOUBLE_VALUE = "double_value"
     static final String ID_FLOATVALUE = "floatValue"
     static final String ID_LONGVALUE = "longValue"
     static final String ID_INTVALUE = "intValue"
    
     GeneratedFirebaseConfig(){
    
            
    }
    private synchronized FirebaseRemoteConfig getRemoteConfig() {
    
            
        if (mRemoteConfig == null) {
                    
            mRemoteConfig = FirebaseRemoteConfig.getInstance()
            
            HashMap<String, Object> defValues = new HashMap<>()
            defValues.put("string_value", "nil")
            defValues.put("double_value", "1.2345")
            defValues.put("floatValue", "1.2300000190734863")
            defValues.put("longValue", "12345")
            defValues.put("intValue", "123")
            mRemoteConfig.setDefaults(defValues)
            
        }
        return mRemoteConfig
        
    }
     String getStringValue(){ return getRemoteConfig().getString("string_value") }
     double getDoubleValue(){ return getRemoteConfig().getDouble("double_value") }
     double getFloatValue(){ return getRemoteConfig().getDouble("floatValue") }
     long getLongValue(){ return getRemoteConfig().getLong("longValue") }
     int getIntValue(){ return (int)getRemoteConfig().getLong("intValue") }
    
}
