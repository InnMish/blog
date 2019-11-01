import {Role} from "../../../_models/role.model";

export interface ArticleCredentials {
  login: string;
  password?: string;
  permissions?: Set<Role>;
}
