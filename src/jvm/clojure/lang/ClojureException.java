package clojure.lang;

public class ClojureException extends RuntimeException {

public ClojureException(String msg) {
	super(msg); 
}
public ClojureException(String msg, Throwable cause) {
	super(msg, cause);
}

public ClojureException(Throwable cause) {
	super(cause);
}

public ClojureException() {
	super();
}

}
    
