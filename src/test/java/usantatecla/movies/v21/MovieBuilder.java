package usantatecla.movies.v21;

public class MovieBuilder {

	private String title;
	
	public MovieBuilder() {
		title = "movieName";
	}
	
	public MovieBuilder title(String title) {
		this.title = title;
		return this;
	}
	
	public ChildrenMovie childrensBuild() {
		return new ChildrenMovie(this.title);
	}
	
	public RegularMovie regularBuild() {
		return new RegularMovie(this.title);
	}
	
	public NewReleaseMovie newReleaseBuild() {
		return new NewReleaseMovie(this.title) ;
	}
}
