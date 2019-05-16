package constant;

import javafx.scene.media.AudioClip;

public class SoundEff {
	public static final AudioClip SOUND_GAME = new AudioClip(ClassLoader.getSystemResource("sound/bgmGame.mp3").toString());
	public static final AudioClip SOUND_START = new AudioClip(ClassLoader.getSystemResource("sound/bgmStart.mp3").toString());
	public static final AudioClip SOUND_END = new AudioClip(ClassLoader.getSystemResource("sound/bgmStart.mp3").toString());
	public static final AudioClip SOUND_GET_HIT = new AudioClip(ClassLoader.getSystemResource("sound/fx_getHit.wav").toString());
	public static final AudioClip SOUND_GHOST_KILLED = new AudioClip(ClassLoader.getSystemResource("sound/fx_ghostKill.wav").toString());
	public static final AudioClip SOUND_HIT = new AudioClip(ClassLoader.getSystemResource("sound/fx_hit.wav").toString());
	public static final AudioClip SOUND_JUMP = new AudioClip(ClassLoader.getSystemResource("sound/fx_jump.wav").toString());
	public static final AudioClip SOUND_PUPPY_DEAD = new AudioClip(ClassLoader.getSystemResource("sound/fx_pDead.wav").toString());
	public static final AudioClip SOUND_THROW_ITEM = new AudioClip(ClassLoader.getSystemResource("sound/fx_throwItem.wav").toString());
}
