/*
Copyright (C) 1997-2001 Id Software, Inc.

This program is free software; you can redistribute it and/or
modify it under the terms of the GNU General Public License
as published by the Free Software Foundation; either version 2
of the License, or (at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.

See the GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program; if not, write to the Free Software
Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.

*/
/* Modifications
   Copyright 2003-2004 Bytonic Software
   Copyright 2010 Google Inc.
*/
package jake2.sound;

import jake2.qcommon.Defines;

import java.nio.ByteBuffer;

/**
 * Sound
 * 
 * @author cwei
 */
public interface SoundImpl {
    
    static final int MAX_SFX = Defines.MAX_SOUNDS * 2;
    static final int STREAM_QUEUE = 8;
	
	String getName();
	
	boolean Init();
	void Shutdown();
	
	/*
	=====================
	S_BeginRegistration
	=====================
	*/
	void BeginRegistration();
	
	/*
	=====================
	S_RegisterSound
	=====================
	*/
	Sfx RegisterSound(String sample);
	
	/*
	=====================
	S_EndRegistration
	=====================
	*/
	void EndRegistration();
	
	/*
	==================
	S_StartLocalSound
	==================
	*/
	void StartLocalSound(String sound);
	
	/*
	====================
	S_StartSound

	Validates the parms and ques the sound up
	if pos is NULL, the sound will be dynamically sourced from the entity
	Entchannel 0 will never override a playing sound
	====================
	*/
	void StartSound(float[] origin, int entnum, int entchannel, Sfx sfx, float fvol, float attenuation, float timeofs);

	/*
	============
	S_Update

	Called once each time through the main loop
	============
	*/
	void Update(float[] origin, float[] forward, float[] right, float[] up);
	/*
	============
	S_RawSamples
	 
	Cinematic streaming and voice over network
	============
	*/
	void RawSamples(int samples, int rate, int width, int channels, ByteBuffer data);

    void disableStreaming();
	/*
	==================
	S_StopAllSounds
	==================
	*/
	void StopAllSounds();

}
