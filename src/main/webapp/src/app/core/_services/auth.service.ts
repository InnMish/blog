import {Role} from "../../_models/role.model";
import {Injectable} from "@angular/core";
import {ArticleCredentials} from "../auth/_models/article-credentials.model";
import {BehaviorSubject, Observable, Subject} from "rxjs";
import {TokenPair} from "../auth/_models/token-pair.model";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Router} from "@angular/router";
import {IntegrationService} from "./integration.service";
import {tap} from "rxjs/operators";

const BACKEND_URL = '/';
const AUTH_TOKEN = 'authToken';
const REFRESH_TOKEN = 'refreshToken';

interface DecodedAccessToken {
  role: Role;
  sub: string;
}

@Injectable()
export class AuthService {
  authStatusListener = new BehaviorSubject<ArticleCredentials | undefined>(undefined);
  tokensListener = new Subject<TokenPair | null>();
  private tokens: TokenPair | null;
  private isAuthenticated = false;

  constructor(private http: HttpClient,
              private router: Router,
              private integrationService: IntegrationService) {

  }

  getTokens() {
    return this.tokens;
  }

  setTokens(tokens: TokenPair) {
    this.tokens = tokens;
    this.tokensListener.next(this.tokens);
    this.clearAuthData();
    this.saveAuthData(this.tokens);
  }

  getAuthStatusListener() {
    return this.authStatusListener.asObservable();
  }

  getAuthUser() {
    return this.authStatusListener.getValue();
  }

  getIsAuth() {
    return this.isAuthenticated;
  }


}
