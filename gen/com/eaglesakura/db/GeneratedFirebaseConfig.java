package com.eaglesakura.db

import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import java.util.HashMap

 class GeneratedFirebaseConfig {
    
    FirebaseRemoteConfig mRemoteConfig
    
     static final String ID_BOOLVALUE = "boolValue"
     static final String ID_ENUMVALUE = "enumValue"
    
     GeneratedFirebaseConfig(){
    
            
    }
    private synchronized FirebaseRemoteConfig getRemoteConfig() {
    
            
        if (mRemoteConfig == null) {
                    
            mRemoteConfig = FirebaseRemoteConfig.getInstance()
            
            HashMap<String, Object> defValues = new HashMap<>()
            defValues.put("boolValue", "false")
            defValues.put("enumValue", "Hoge")
            mRemoteConfig.setDefaults(defValues)
            
        }
        return mRemoteConfig
        
    }
     boolean isBoolValue(){ return getRemoteConfig().getBoolean("boolValue") }
     coom.eaglesakura.sloth.firebase.TestEnum getEnumValue(){ try{ return coom.eaglesakura.sloth.firebase.TestEnum.valueOf(getRemoteConfig().getString("enumValue")) }catch(Exception e){ return null } }
    
}
