package model;

public class Channel {

	private String name;
	private String [] bgm;
	private Follower [] followers;
	private int maxfollows, maxposts, follows, posts;

	public Channel(String name, int maxfollows, int maxposts) {
		this.name = name;
		this.maxfollows = maxfollows;
		this.maxposts = maxposts;
		posts = 0;
		follows = 0;
		bgm = new String[maxposts];
		followers = new Follower[maxfollows];
	}

	public String toString() {
		String str = name + " released ";

		if (posts == 0) {
			str += "no videos ";
		}

		else {
			str += "<";
			// bgms "> and has no followers."
			for(int i =0; i<bgm.length; i++) {
				if (bgm[i] != null) {
					str += bgm[i];
					if(i < bgm.length - 1 && bgm[i+1] != null) {
						str+= ", ";
					}
				}
			}
			str += "> ";
		}
		str += "and ";

		if (follows == 0) {
			str += "has no followers.";
		}
		else {
			str += "is followed by [";

			for(int i =0; i< followers.length; i++) {
				if (followers[i] != null) {
					str += followers[i].getTypeOfFollower() + " " + followers[i].getName();
					if(followers[i+1] != null) {
						str += ", ";
					}
				}
			}
			str += "].";
		}

		return str;
	}

	public void releaseANewVideo(String video) {

		for(int i =0; i< bgm.length; i++) {
			if (bgm[i] == null) {
				bgm[i] = video;
				posts++;

				//if theres alrdy a follwer then add the new song to their array
				for(int j =0; j< followers.length; j++) {
					if (followers[j] != null) {
						followers[j].addNewSong(video);
					}
				}
				break;
			}
		}
	}

	public void follow(Follower f) {
		for(int i =0; i< followers.length; i++) {
			if (followers[i] == null) {
				followers[i] = f;
				follows++;
				followers[i].followChannel(this);
				break;
			}
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getBgm() {
		return bgm;
	}

	public void setBgm(String[] bgm) {
		this.bgm = bgm;
	}

	public Follower[] getFollowers() {
		return followers;
	}

	public void setFollowers(Follower[] followers) {
		this.followers = followers;
	}

	public int getMaxfollows() {
		return maxfollows;
	}

	public void setMaxfollows(int maxfollows) {
		this.maxfollows = maxfollows;
	}

	public int getMaxposts() {
		return maxposts;
	}

	public void setMaxposts(int maxposts) {
		this.maxposts = maxposts;
	}

	public int getFollows() {
		return follows;
	}

	public void setFollows(int follows) {
		this.follows = follows;
	}

	public int getPosts() {
		return posts;
	}

	public void setPosts(int posts) {
		this.posts = posts;
	}

	public void unfollow(Follower f) {
		for(int i =0; i< followers.length; i++) {
			if (followers[i] != null) {
				if (followers[i] == f) {
					followers[i].unfollowChannel(this);
					followers[i] = null;
					follows--;
					break;
				}
			}
		}
	}
}