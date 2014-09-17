package game.dev.sounds;

import paulscode.sound.SoundSystem;
import paulscode.sound.libraries.LibraryLWJGLOpenAL;
import paulscode.sound.codecs.CodecJOrbis;
import paulscode.sound.SoundSystemConfig;
import paulscode.sound.SoundSystemException;


/**
* @author Nikola Djukic
*
*/
public class SEngine {
        private static SoundSystem s=null;//Static field keeping track of if the SoundSystem was initialized.
        
        /**
         * Singleton getter function for SoundSystem.
         * @return The SoundSystem of the given system.
         */
        public static SoundSystem getSoundSystem(){
                if (s==null) {
                        init();//allocate new SoundSystem if one is not present and link the neccessary libs.
                        }
                return s;
        }
        
        /**
         * Singleton initializer function for SoundSystem.
         */
        public static void init(){
                try
                {
                        SoundSystemConfig.addLibrary( LibraryLWJGLOpenAL.class );//dynamically load OpenAL lib
                }
                catch( SoundSystemException e )
                {
                        System.err.println( "error linking with lib" );
                }
                
                try
                {
                        SoundSystemConfig.setCodec("ogg", CodecJOrbis.class);//select OGG decoder
                }catch( SoundSystemException e ){
                        System.err.println("error linking with the CodecWav plug-in" );
                }
                
                if(s==null)
                        s=new SoundSystem();//if not sound system was present make a new one
                s.setListenerOrientation( 0, 0, -1, 0, -1, 0 );//set orientation to look at the screen
                loadSounds();//TODO maybe make a new class? similar to LoadTex? (expensive operation)
        }
        
        public static void loadSounds(){
        		
                SEngine.getSoundSystem().loadSound("buttonclick.ogg");
                SEngine.getSoundSystem().newSource(false, "buttonclick", "buttonclick.ogg", false, 0, 0, 0, 0, 0);
                SEngine.getSoundSystem().loadSound("splashsound.ogg");
                SEngine.getSoundSystem().loadSound("explode.ogg");
                SEngine.getSoundSystem().newSource(false, "explode", "explode.ogg", false, 0, 0, 0, 0, 0);
                SEngine.getSoundSystem().loadSound("flood.ogg");
                SEngine.getSoundSystem().newSource(false, "flood", "flood.ogg", false, 0, 0, 0, 0, 0);
                SEngine.getSoundSystem().loadSound("lumbermill.ogg");
                SEngine.getSoundSystem().newSource(false, "lumbermill", "lumbermill.ogg", false, 0, 0, 0, 0, 0);
                SEngine.getSoundSystem().loadSound("plague.ogg");
                SEngine.getSoundSystem().newSource(false, "plague", "plague.ogg", false, 0, 0, 0, 0, 0);
                SEngine.getSoundSystem().loadSound("protest.ogg");
                SEngine.getSoundSystem().newSource(false, "protest", "protest.ogg", false, 0, 0, 0, 0, 0);
                SEngine.getSoundSystem().loadSound("earthquake.ogg");
                SEngine.getSoundSystem().newSource(false, "earthquake", "earthquake.ogg", false, 0, 0, 0, 0, 0);
               
        }
        
        
        
        public static void dispose(){
                s.cleanup();//clean up the sonud system
                }
        
        
        
        

}