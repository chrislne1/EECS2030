package model;

public class Follower {

	private String name, str;
	private String typeOfFollower;
	private int maxchannels, maxvideos, numofchannels, numofvideos;
	private Channel[] channels;
	private String[] newvideos;
	private int[] ch_views;
	private int[] ch_maxmins;
	private int[] ch_totmins;
	private double[] ch_avgmins;


	public Follower() {
		numofchannels = 0;
		numofvideos = 0;
		newvideos = new String[20];
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMaxchannels() {
		return maxchannels;
	}

	public void setMaxchannels(int maxchannels) {
		this.maxchannels = maxchannels;
		channels = new Channel[maxchannels];
		
	    ch_views = new int[maxchannels];
	    ch_maxmins = new int[maxchannels];
	    ch_totmins = new int[maxchannels];
	    ch_avgmins = new double[maxchannels];
	}

	public int getMaxvideos() {
		return maxvideos;
	}


	public String toString() {
		return str;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public int getNumofchannels() {
		return numofchannels;
	}

	public void setNumofchannels(int numofchannels) {
		this.numofchannels = numofchannels;
	}

	public int getNumofvideos() {
		return numofvideos;
	}

	public void setNumofvideos(int numofvideos) {
		this.numofvideos = numofvideos;
	}

	public Channel[] getChannels() {
		return channels;
	}

	public void followChannel(Channel c) {
		for(int i =0; i< channels.length; i++) {
			if (channels[i] == null) {
				channels[i] = c;
				numofchannels++;
				break;
			}
		}
	}

	public void unfollowChannel(Channel c) {
		for(int i =0; i< channels.length; i++) {
			if (channels[i] != null) {
				if (channels[i] == c) {
					//loop though songs in the channel
					for(int j =0; j< c.getBgm().length; j++) {
						if (c.getBgm()[j] != null) {
							//loop through the length of storred new songs
							for(int k =0; k< newvideos.length; k++) {
								if (newvideos[k] != null) {
									//If the indexed song in the channel unfollowing matches the song in our recommend delete the song
									if (c.getBgm()[j].equals(newvideos[k])) {
										newvideos[k] = null;
										numofvideos--;
									}
								}

							}
						}
					}
					channels[i] = null;
					numofchannels--;
					break;
				}
			}
		}
	}

	public String getTypeOfFollower() {
		return typeOfFollower;
	}

	public void setTypeOfFollower(String typeOfFollower) {
		this.typeOfFollower = typeOfFollower;
	}

	public void setChannels(Channel[] channels) {
		this.channels = channels;
	}

	public void setMaxvideos(int maxvideos) {
		this.maxvideos = maxvideos;		
	}

	public String[] getNewVideos() {
		return newvideos;
	}

	public void setNewVideos(String[] oldvideos) {
		this.newvideos = oldvideos;
	}

	public void addNewSong(String video) {
		for(int i =0; i < newvideos.length; i++) {
			if (newvideos[i] == null) {
				newvideos[i] = video;
				numofvideos++;
				break;
			}
		}
	}

	public void updateVideo(String video, int mins) {

//		for(int i=0; i<channels.length; i++) {
//			if(channels[i] != null) {
//				for(int j =0; j< channels[i].getBgm().length; j++) {
//					if(channels[i].getBgm()[j] != null && channels[i].getBgm()[j].equals(video)) {
//												totviews++;
//												totmins += mins;
//												
//												if (mins > maxmins) {
//													maxmins = mins;
//												}
//												
//												avgmins = Math.round((totmins / (double) totviews) * 100.0) / 100.0;
//					}
//				}
//			}
//		}

		for(int c = 0; c < channels.length; c++) {
		    if (channels[c] != null) {
		        for (int b = 0; b < channels[c].getBgm().length; b++) {

		            if (channels[c].getBgm()[b] != null &&
		                channels[c].getBgm()[b].equals(video)) {

		                // correct channel found → update stats for index c
		                ch_views[c]++;
		                ch_totmins[c] += mins;

		                if (mins > ch_maxmins[c]) {
		                    ch_maxmins[c] = mins;
		                }

		                ch_avgmins[c] = Math.round((ch_totmins[c] / (double) ch_views[c]) * 100.0) / 100.0;

		                return;
		            }
		        }
		    }
		}

	}

	public String[] getNewvideos() {
		return newvideos;
	}

	public void setNewvideos(String[] newvideos) {
		this.newvideos = newvideos;
	}

	public int[] getCh_views() {
		return ch_views;
	}

	public void setCh_views(int[] ch_views) {
		this.ch_views = ch_views;
	}

	public int[] getCh_maxmins() {
		return ch_maxmins;
	}

	public void setCh_maxmins(int[] ch_maxmins) {
		this.ch_maxmins = ch_maxmins;
	}

	public int[] getCh_totmins() {
		return ch_totmins;
	}

	public void setCh_totmins(int[] ch_totmins) {
		this.ch_totmins = ch_totmins;
	}

	public double[] getCh_avgmins() {
		return ch_avgmins;
	}

	public void setCh_avgmins(double[] ch_avgmins) {
		this.ch_avgmins = ch_avgmins;
	}

}
